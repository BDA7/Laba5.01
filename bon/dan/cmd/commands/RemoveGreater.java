package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.MusicBand;
import bon.dan.struct.csv.MusicBandReader;

public class RemoveGreater extends Command {
    public RemoveGreater(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes the greater MusicBand elements from the collection";
    }

    @Override
    public void run() throws Exception {
        MusicBand mb = MusicBandReader.read(this.cmd.scanner, this.cmd.sink);

        this.cmd.struct.stream()
                .filter(musicBand -> musicBand.compareTo(mb) > 0)
                .forEach(this.cmd.struct::remove);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
