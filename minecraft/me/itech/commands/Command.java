package me.itech.commands;

public abstract class Command
{
    protected final String[] aliases;
    protected final String command;
    protected final String arguments;
    
    public Command(final String command, final String arguments, final String... aliases) {
        this.command = command;
        this.arguments = arguments;
        this.aliases = aliases;
    }
    
    public String[] getAliases() {
        return this.aliases;
    }
    
    public String getArguments() {
        return this.arguments;
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public abstract void run(final String p0);
}
