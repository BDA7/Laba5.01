package bon.dan.struct;

import bon.dan.struct.substruct.Coordinates;
import bon.dan.struct.substruct.Label;
import bon.dan.struct.substruct.MusicGenre;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MusicBand implements Comparable<MusicBand> {
    private static int incrementId = 1;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private long albumsCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Label label; //Поле может быть null

    public MusicBand(String name, String numberOfParticipants, String albumsCount, String coordX, String coordY) throws Exception {
        setName(name);
        setNumberOfParticipants(numberOfParticipants);
        setAlbumsCount(albumsCount);
        setCoordinates(coordX, coordY);

        this.creationDate = LocalDateTime.now();
        this.id = incrementId++;
    }


    @Override
    public int compareTo(MusicBand musicBand) {

        int result = -this.name.compareTo(musicBand.name);

        if (result == 0)
            result = -this.numberOfParticipants.compareTo(musicBand.numberOfParticipants);

        if (result == 0)
            result = -Long.compare(this.albumsCount, musicBand.albumsCount);

        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Invalid name");
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinatesX, String coordinatesY) throws Exception {
        if (coordinatesX.length() > 10 || coordinatesY.length() > 10)
            throw new Exception("Too big coords");

        if (coordinatesX.equals("") || coordinatesY.equals(""))
            this.coordinates = null;
        try {
            float coordX = Float.parseFloat(coordinatesX);
            float coordY = Float.parseFloat(coordinatesY);
            this.coordinates = new Coordinates(coordX, coordY);
        } catch (Exception e) {
            throw new Exception("Invalid coords format\n" + e.getMessage());
        }
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) throws Exception {
        try {
            this.creationDate = LocalDateTime.parse(creationDate);
        } catch (Exception e) {
            throw new Exception("Invalid datetime format\n" + e.getMessage());
        }
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(String numberOfParticipants) throws Exception {
        try {
            Integer num = Integer.parseInt(numberOfParticipants);
            if (num <= 0)
                throw new Exception("Invalid numberOfParticipants (must be > 0)");

            this.numberOfParticipants = num;

        } catch (Exception e) {
            throw new Exception("Invalid numberOfParticipants format\n" + e.getMessage());
        }


    }

    public long getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(String albumsCount) throws Exception {
        try {

            Integer count = Integer.parseInt(albumsCount);

            if (count <= 0)
                throw new Exception("Invalid numberOfParticipants (must be > 0)");

            this.albumsCount = count;
        } catch (Exception e) {
            throw new Exception("Invalid albumsCount format\n" + e.getMessage());
        }
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(String genreName) throws Exception {
        if (genreName.equals(""))
            this.genre = null;
        else {
            this.genre = MusicGenre.fromString(genreName);
        }
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (label.equals(""))
            this.label = null;
        else
            this.label = new Label(label);
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) +
                ", numberOfParticipants=" + numberOfParticipants +
                ", albumsCount=" + albumsCount +
                ", genre=" + genre +
                ", label=" + label +
                '}';
    }
}

