package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

public class History extends Command {

    public History(Cmd cmd) {
        super(cmd);
        this.helpInfo = String.format("Shows last %d used commands", this.cmd.MAX_HISTORY_SIZE);
    }

    @Override
    public void run() {
        cmd.history.forEach(cmd.sink::println);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (!this.args.isEmpty()) {
            throw new Exception("Too many arguments");
        }
    }
}
