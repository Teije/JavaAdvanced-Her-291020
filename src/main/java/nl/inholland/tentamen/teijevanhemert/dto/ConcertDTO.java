package nl.inholland.tentamen.teijevanhemert.dto;

public class ConcertDTO
{
    private String artist;
    private String venueName;
    private String date;

    public ConcertDTO(String artist, String venueName, String date)
    {
        this.artist = artist;
        this.venueName = venueName;
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
