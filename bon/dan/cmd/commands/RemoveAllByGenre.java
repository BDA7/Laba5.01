package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.substruct.MusicGenre;

public class RemoveAllByGenre extends Command {
    public RemoveAllByGenre(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes all MusicBand elements with genre equals <genre> passed as a parameter";
    }

    @Override
    public void run() throws Exception {
        MusicGenre musicGenre = MusicGenre.fromString(this.args.get(0));
        this.cmd.struct.stream()
                .filter(musicBand -> musicBand.getGenre() != null
                        && musicBand.getGenre().equals(musicGenre))
                .forEach(this.cmd.struct::remove);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid number of arguments");
    }
}
