package example.example.commands.impl;

import example.example.commands.CommandContext;
import example.example.commands.ICommand;

public class HelloWorldCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        ctx.getEvent().deferReply(true).setContent("Hello World!").queue();
    }

    @Override
    public String getName() {
        return "helloworld";
    }

    @Override
    public String getDescription() {
        return "says hello world";
    }
}
