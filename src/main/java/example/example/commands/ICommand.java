package example.example.commands;

import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;

import java.util.Arrays;
import java.util.List;

public interface ICommand {

    void handle(CommandContext ctx);
    String getName();
    String getDescription();

    default List<SubcommandGroupData> getSubgroup() {return Arrays.asList(); }
    default List<SubcommandData> getSubcommands() {
        return Arrays.asList();
    }
    default List<OptionData> getOptions() { return Arrays.asList(); }

}
