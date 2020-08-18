package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

import java.util.ArrayList;

/**
 * Class represents command in interactive interpreter
 */
public abstract class Command {

    /**
     * Reference to interactive interpreter (used for access user input, output and main structure @see Struct)
     */
    final Cmd cmd;
    /**
     * Arguments transferred from user input
     */
    ArrayList<String> args;
    /**
     * Help information for help command @see Help
     */
    String helpInfo;

    Command(Cmd cmd) {
        this.cmd = cmd;
    }

    public void execute() throws Exception {
        checkArgs();
        run();
    }

    protected abstract void run() throws Exception;

    /**
     * Checks user input
     */
    protected abstract void checkArgs() throws Exception;

    public void setArgs(ArrayList<String> args) throws Exception {
        this.args = args;
        checkArgs();
    }

    public String getHelpInfo() {
        return helpInfo;
    }
}
