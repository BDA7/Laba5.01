package bon.dan;

import bon.dan.cmd.Cmd;
import bon.dan.struct.Struct;


import java.nio.file.Path;
import java.nio.file.Paths;

final class App {
    private Cmd cmd;
    private Struct struct;
    private Path ffPath;

    App(String[] args) {
        if (args.length > 0) {
            ffPath = Paths.get(args[0]);
        } else {
            System.err.println("Set the path to ff file");
            System.exit(1);
        }
    }


    int exec() {
        try {
            struct = Struct.fromDatabase(ffPath);
        } catch (Exception e) {
            System.err.println("Cannot read db file\n" + e.getMessage());
            return 1;
        }

        cmd = new Cmd(System.in, System.out, this.struct);

        try {
            cmd.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 1;
        }

        return 0;
    }

}
