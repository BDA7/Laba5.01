package bon.dan.struct.csv;

import bon.dan.struct.MusicBand;
import bon.dan.struct.substruct.MusicGenre;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MusicBandReader {
    public static MusicBand read(Scanner scanner, PrintStream sink) throws Exception {

        MusicBand musicBanddd = new MusicBand("Dummy", "1",
                "1", "0", "0");

        while (true) {
            sink.println("Enter <name>;<number_of_participants>;<albums_count> :");
            List<String> firstParams = Arrays.asList(scanner.nextLine().split(";", -1));
            if (firstParams.size() != 3) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                musicBanddd.setName(firstParams.get(0));
                musicBanddd.setNumberOfParticipants(firstParams.get(1));
                musicBanddd.setAlbumsCount(firstParams.get(2));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            sink.println("Enter coordinates like <x>;<y> :");
            List<String> coordinates = Arrays.asList(scanner.nextLine().split(";", -1));
            if (coordinates.size() != 2) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                musicBanddd.setCoordinates(coordinates.get(0), coordinates.get(1));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            sink.println("Enter label like <label_name> :");
            List<String> label = Arrays.asList(scanner.nextLine().split(";", -1));
            if (label.size() != 1) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                musicBanddd.setLabel(label.get(0));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }

        while (true) {
            sink.println("Enter genre like <genre> :");
            sink.println("Genres :");
            Arrays.asList(MusicGenre.values()).forEach(sink::println);

            List<String> genre = Arrays.asList(scanner.nextLine().split(";", -1));

            if (genre.size() != 1) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                musicBanddd.setGenre(genre.get(0));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        return musicBanddd;
    }
}
