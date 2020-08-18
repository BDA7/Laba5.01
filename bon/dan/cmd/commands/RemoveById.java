package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

public class RemoveById extends Command {
    public RemoveById(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes MusicBand element with <id> from collection";
    }

    @Override
    public void run() throws Exception {
        int id = Integer.parseInt(args.get(0));
        this.cmd.struct.stream().filter(el -> el.getId() == id).forEach(cmd.struct::remove);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid arguments");
        try {
            Integer.parseInt(args.get(0));
        } catch (Exception e) {
            throw new Exception("Invalid id format\n" + e.getMessage());
        }
    }
}
