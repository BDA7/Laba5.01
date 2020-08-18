package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;
import bon.dan.struct.Struct;
import bon.dan.struct.csv.CSVSerializer;


import java.nio.file.Files;
import java.nio.file.Path;

public class Save extends Command {
    public Save(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Saves a collection into database";
    }

    @Override
    public void run() throws Exception {
        boolean iswrite = Files.isWritable(Struct.ffFileName);
        if (!iswrite)
            System.err.println("FIle not is Writable");
        else Files.write(Struct.ffFileName, CSVSerializer.serialize(this.cmd.struct));
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }


}
