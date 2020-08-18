package bon.dan.cmd.commands;

import bon.dan.cmd.Cmd;

import java.io.FileInputStream;
import java.util.HashMap;


public class ExecuteScript extends Command {

    private static HashMap<String, Integer> usedFile = new HashMap<>();

    public ExecuteScript(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Interprets the script file passed as a parameter <file_path>";
    }

    @Override
    public void run() throws Exception {

        if (usedFile.containsKey(this.args.get(0)))
            usedFile.put(this.args.get(0), usedFile.get(this.args.get(0)) + 1);
        else
            usedFile.put(this.args.get(0), 1);

        if (usedFile.get(this.args.get(0)) > 1)
            throw new Exception("Recursion limit");

        Cmd virtualCmd = new Cmd(new FileInputStream(this.args.get(0)), System.out, this.cmd.struct);
        virtualCmd.start();
        usedFile.clear();
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1) {
            throw new Exception("Invalid arguments");
        }
    }
}
