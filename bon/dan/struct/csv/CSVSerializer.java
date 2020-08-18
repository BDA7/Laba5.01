package bon.dan.struct.csv;

import bon.dan.struct.MusicBand;
import bon.dan.struct.Struct;

public class CSVSerializer {

    static final String header = "name;coord_x;coord_y;creation_date;participants_num;albums_count;genre;label";

    public static byte[] serialize(Struct struct) {
        StringBuilder data = new StringBuilder();
        data.append(header).append("\n");

        for (MusicBand mb : struct) {
            data.append(mb.getName()).append(';');

            data.append(mb.getCoordinates().getX()).append(';');
            data.append(mb.getCoordinates().getY()).append(';');

            data.append(mb.getCreationDate().toString()).append(';');
            data.append(mb.getNumberOfParticipants()).append(';');
            data.append(mb.getAlbumsCount()).append(';');

            if (mb.getGenre() != null)
                data.append(mb.getGenre().toString());
            data.append(';');

            if (mb.getLabel() != null)
                data.append(mb.getLabel().getName());
            data.append('\n');
        }
        return data.toString().getBytes();
    }
}
