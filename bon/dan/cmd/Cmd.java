package bon.dan.cmd;

import bon.dan.cmd.commands.*;
import bon.dan.struct.Struct;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Cmd {
    public final int MAX_HISTORY_SIZE = 17;
    public final LinkedList<String> history = new LinkedList<>();
    public final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
    public final Struct struct;
    public final Scanner scanner;
    public final PrintStream sink;
    private boolean stop = false;

    public Cmd(InputStream source, PrintStream sink, Struct struct) {
        this.struct = struct;
        this.scanner = new Scanner(source);
        this.sink = sink;

        commands.put("exit", new Exit(this));
        commands.put("help", new Help(this));
        commands.put("history", new History(this));
        commands.put("add", new Add(this));
        commands.put("add_if_max", new AddIfMax(this));
        commands.put("clear", new Clear(this));
        commands.put("count_less_than_genre", new CountLessThanGenre(this));
        commands.put("execute_script", new ExecuteScript(this));
        commands.put("filter_contains_name", new FilterContainsName(this));
        commands.put("remove_all_by_genre", new RemoveAllByGenre(this));
        commands.put("remove_greater", new RemoveGreater(this));
        commands.put("save", new Save(this));
        commands.put("show", new Show(this));
        commands.put("update", new Update(this));
        commands.put("remove_by_id", new RemoveById(this));
    }

    public void start() {

        while (!stop) {
            sink.print(">> ");
            if (!scanner.hasNextLine())
                break;

            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");

            if (!tokenizer.hasMoreTokens())
                continue;

            String command = tokenizer.nextToken();

            ArrayList<String> args = new ArrayList<>();

            while (tokenizer.hasMoreTokens())
                args.add(tokenizer.nextToken());

            if (commands.containsKey(command)) {
                Command c = commands.get(command);
                try {
                    c.setArgs(args);
                    c.execute();
                } catch (Exception e) {
                    sink.println(e.getMessage());
                    sink.println(c.getHelpInfo());
                }
            } else {
                sink.println("Unknown command, use help");
            }
            if (this.history.size() >= this.MAX_HISTORY_SIZE)
                this.history.removeFirst();

            this.history.addLast(command);
        }
    }

    public void stop() {
        this.stop = true;
    }

}
