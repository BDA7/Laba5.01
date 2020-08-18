package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

/**
 * Simply removes all elements from the collection
 */
public class Clear extends Command {
    public Clear(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes all MusicBand elements from collection";
    }

    @Override
    public void run() {
        this.cmd.struct.clear();
    }

    @Override
    protected void checkArgs() throws Exception {
        if (!this.args.isEmpty()) {
            throw new Exception("Too many arguments");
        }
    }
}
