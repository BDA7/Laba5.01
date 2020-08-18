package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.substruct.MusicGenre;

public class CountLessThanGenre extends Command {
    public CountLessThanGenre(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints the number of elements in the collection with genre less than <genre> passed as a parameter";
    }

    @Override
    public void run() throws Exception {
        MusicGenre genre = MusicGenre.fromString(args.get(0));

        long count = cmd.struct.stream()
                .filter(musicBand -> musicBand.getGenre() != null
                        && genre.compareTo(musicBand.getGenre()) < 0)
                .count();

        this.cmd.sink.println(String.format("Less than %s: %d", genre.name(), count));
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1) {
            throw new Exception("Should be only one argument");
        }
    }
}
