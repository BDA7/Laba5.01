package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.MusicBand;
import bon.dan.struct.csv.MusicBandReader;

/**
 * Similar to {@link Add}, but adds element only if its greater than max element in the collection
 */
public class AddIfMax extends Command {
    public AddIfMax(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Adds MusicBand element if its greater than max element in the collection";
    }

    @Override
    public void run() throws Exception {
        MusicBand musicBand = MusicBandReader.read(this.cmd.scanner, this.cmd.sink);

        if (!this.cmd.struct.isEmpty()) {
            MusicBand max = this.cmd.struct.stream().max(MusicBand::compareTo).get();
            if (musicBand.compareTo(max) > 0)
                this.cmd.struct.addFirst(musicBand);
            else
                this.cmd.sink.println("Element is less than max element");
        } else
            this.cmd.struct.addFirst(musicBand);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
