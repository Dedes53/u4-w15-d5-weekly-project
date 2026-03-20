package federicolepore.entities;

public class BoardGames extends Games {

    //    attributi
    private final int players;
    private final double duration;

    //    costruttore
    public BoardGames(long id, String title, int year, double price, Players players, double duration) {
        super(id, title, year, price);
        this.players = players.getValue();
        this.duration = duration;
    }


    public int getPlayers() {
        return players;
    }

    public double getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", n. giocatori= " + players +
                ", durata= " + duration + "}";
    }
}
