package federicolepore.entities;

public class VideoGames extends Games {

    //    attributi
    private String platform;
    private double duration;
    private Genres genre;

    //    costruttore
    public VideoGames(long id, String title, int year, double price, String platform, double duration, Genres genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }


    public String getPlatform() {
        return platform;
    }

    public double getDuration() {
        return duration;
    }

    public Genres getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", n. giocatori= " + platform +
                ", durata= " + duration +
                ", genere= " + genre + "}";
    }

}
