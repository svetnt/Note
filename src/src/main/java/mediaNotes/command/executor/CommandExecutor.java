package mediaNotes.command.executor;

import mediaNotes.command.CommandType;

public interface CommandExecutor {

    int execute(String text);

    CommandType getCommandType();
}
