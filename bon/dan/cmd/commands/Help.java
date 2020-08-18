package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

public class Help extends Command {

    public Help(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Shows info about all commands";
    }

    @Override
    public void run() {
        this.cmd.commands.forEach((name, command) -> cmd.sink.println(name + " : " + command.helpInfo + "\n"));
    }

    @Override
    protected void checkArgs() throws Exception {
        if (!this.args.isEmpty()) {
            throw new Exception("Too many arguments");
        }
    }
}
