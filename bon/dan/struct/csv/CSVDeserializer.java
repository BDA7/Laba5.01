package bon.dan.struct.csv;

import bon.dan.struct.MusicBand;
import bon.dan.struct.Struct;

import java.util.Arrays;
import java.util.List;

public class CSVDeserializer {
    public static Struct deserialize(String rawData) throws Exception {
        Struct struct = new Struct();
        List<String> objects = Arrays.asList(rawData.split("\n"));

        if (objects.size() == 0)
            return struct;

        String header = objects.get(0);

        if (!CSVSerializer.header.equals(header)) {
            throw new Exception("Invalid CSV format");
        }

        for (String line : objects) {
            if (line.equals("") || header.equals(line))
                continue;

            List<String> params = Arrays.asList(line.split(";", -1));
            if (params.size() != CSVSerializer.header.split(";").length)
                throw new Exception("Invalid CSV format");

            String name = params.get(0);
            String coordX = params.get(1);
            String coordY = params.get(2);
            String creationDate = params.get(3);
            String participantsNum = params.get(4);
            String albumsCount = params.get(5);
            String genre = params.get(6);
            String labelName = params.get(7);

            MusicBand mb = new MusicBand(name, participantsNum, albumsCount, coordX, coordY);
            mb.setCreationDate(creationDate);
            mb.setGenre(genre);
            mb.setLabel(labelName);
            struct.addFirst(mb);
        }
        return struct;
    }
}
