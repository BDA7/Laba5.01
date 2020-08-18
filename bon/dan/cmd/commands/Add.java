package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.MusicBand;
import bon.dan.struct.Struct;
import bon.dan.struct.csv.MusicBandReader;

/**
 * Command used for simply adding element {@link MusicBand} to collection {@link Struct}
 */
public class Add extends Command {
    public Add(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Add new MusicBand to collection\n" +
                "\tfirst pass <name>;<number_of_participants>;<albums_count>\n" +
                "\tthen pass coordinates like <x>;<y>\n" +
                "\tlabel and genre could be empty";
    }

    @Override
    public void run() throws Exception {
        MusicBand musicBand = MusicBandReader.read(this.cmd.scanner, this.cmd.sink);
        this.cmd.struct.addFirst(musicBand);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
