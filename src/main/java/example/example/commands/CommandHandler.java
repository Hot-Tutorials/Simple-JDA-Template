package example.example.commands;

import example.example.commands.impl.HelloWorldCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandHandler extends ListenerAdapter {

    public CommandHandler() {
        register(new HelloWorldCommand());
    }

    private List<ICommand> commandList = new ArrayList<>();

    public List<ICommand> getCommandList() {
        return commandList;
    }

    public void register(ICommand cmd) {
        if(commandList.contains(cmd)) {
            return;
        }
        commandList.add(cmd);
    }

    @Nullable
    public ICommand getCommand(String name) {
        for(ICommand cmd : commandList) {
            if(cmd.getName().equalsIgnoreCase(name)) {
                return cmd;
            }
        }
        return null;
    }

    public void init(Guild guild) {
        CommandListUpdateAction cmdsList = guild.updateCommands();
        for(ICommand command : commandList) {
            CommandData data = new CommandData(command.getName(), command.getDescription());
            if(!command.getSubgroup().isEmpty()) {
                data.addSubcommandGroups(command.getSubgroup());
            } else if(!command.getSubcommands().isEmpty()){
                data.addSubcommands(command.getSubcommands());
            } else {
                data.addOptions(command.getOptions());
            }

            cmdsList.addCommands(data);
        }

        List<Command> cmds = cmdsList.complete();
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        ICommand command = getCommand(event.getName());

        if(command == null) {
            return;
        }

        CommandContext ctx = new CommandContext(event);

        command.handle(ctx);

    }
}
