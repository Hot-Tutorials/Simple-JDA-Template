package example.example.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class CommandContext {

    private SlashCommandEvent event;

    public CommandContext(SlashCommandEvent event) {
        this.event = event;
    }

    public SlashCommandEvent getEvent() {
        return event;
    }

    public TextChannel getChannel() {
        return event.getTextChannel();
    }

    public User getUser() {
        return event.getUser();
    }

    public Member getMember() {
        return event.getMember();
    }

    public Guild getGuild() {
        return event.getGuild();
    }

    public String getName() {
        return event.getName();
    }

    public OptionMapping getOption(String name) {
        return event.getOption(name);
    }

    public List<OptionMapping> getOptions() {
        return event.getOptions();
    }

    public String getSubCmdGroup() {
        return event.getSubcommandGroup();
    }

    public String getSubCmdName() {
        return event.getSubcommandName();
    }

}
