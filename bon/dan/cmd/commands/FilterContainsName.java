package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

public class FilterContainsName extends Command {
    public FilterContainsName(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints all MusicBand elements with name contains <substring>";
    }

    @Override
    public void run() {
        String subName = this.args.get(0);

        this.cmd.struct.stream()
                .filter(musicBand -> musicBand.getName().contains(subName))
                .forEach(this.cmd.sink::println);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid arguments");
    }
}
