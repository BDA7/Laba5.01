package bon.dan.struct.substruct;

public enum MusicGenre implements Comparable<MusicGenre> {
    ROCK,
    SOUL,
    BLUES,
    POP,
    POST_PUNK;

    public static MusicGenre fromString(String genreName) throws Exception {
        if (genreName.equals("ROCK"))
            return MusicGenre.ROCK;
        if (genreName.equals("SOUL"))
            return MusicGenre.SOUL;
        if (genreName.equals("BLUES"))
            return MusicGenre.BLUES;
        if (genreName.equals("POP"))
            return MusicGenre.POP;
        if (genreName.equals("POST_PUNK"))
            return MusicGenre.POST_PUNK;

        throw new Exception("Invalid Music Genre");
    }


}
