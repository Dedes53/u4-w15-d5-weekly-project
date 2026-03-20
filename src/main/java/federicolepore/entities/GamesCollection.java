package federicolepore.entities;

import java.util.ArrayList;
import java.util.List;

public class GamesCollection {

    //   attributi
    private List<Games> gamesList = new ArrayList<>();

    //   costruttore
    public GamesCollection(List games) {
        this.gamesList = games;
    }

    //   metodi
    public void addGames(Games game) {


        gamesList.add(game);
    }

}


