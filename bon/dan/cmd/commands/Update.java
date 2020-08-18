package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.MusicBand;
import bon.dan.struct.csv.MusicBandReader;

public class Update extends Command {
    public Update(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Rewrites a MusicBand element by <id>";
    }

    @Override
    public void run() throws Exception {
        int id = Integer.parseInt(this.args.get(0));
        MusicBand musicBand = this.cmd.struct.stream().filter(mb -> mb.getId() == id).findFirst().orElse(null);

        if (musicBand == null)
            throw new Exception(String.format("Can not find object with id: %d", id));

        MusicBand newMb = MusicBandReader.read(this.cmd.scanner, this.cmd.sink);

        this.cmd.struct.remove(musicBand);
        this.cmd.struct.addFirst(newMb);
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
