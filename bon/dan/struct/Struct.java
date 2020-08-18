package bon.dan.struct;

import bon.dan.struct.csv.CSVDeserializer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;


public class Struct extends LinkedList<MusicBand> {
    public static Path ffFileName;

    public static Struct fromDatabase(Path ff) throws Exception {
        ffFileName = ff;
        String rawData = new String(Files.readAllBytes(ffFileName));
        return CSVDeserializer.deserialize(rawData);
    }


    @Override
    public String toString() {
        return "Struct{}";
    }
}
