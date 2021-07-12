package example.example;

import example.example.commands.CommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;

public class Bot extends Thread{

    public static void main(String[] args) {
        Bot bot = new Bot();
        bot.start();
    }

    private static JDA jda;

    @Override
    public void run() {

        try {
            jda = JDABuilder.createDefault("token")
                    .build();

            for (Guild guild : jda.awaitReady().getGuilds()) {
                getCommandHandler().init(guild);
            }

            jda.addEventListener(new CommandHandler());

        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static CommandHandler getCommandHandler() {
        return new CommandHandler();
    }

    public static JDA getJDA() {
        return jda;
    }

}
