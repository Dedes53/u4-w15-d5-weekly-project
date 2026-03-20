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
    public void addGame(Games game) {

        if (game == null) throw new IllegalArgumentException("Devi provare ad aggiungere un gioco, non aria");
        boolean idIsDifferent = gamesList.stream().anyMatch(g -> g.getId() == game.getId());

        if (!idIsDifferent)
            throw new IllegalArgumentException("Nella lista un gioco con id: " + game.getId() + "esiste già.");

        gamesList.add(game);
    }

    public Games searchById(long id) {

        for (Games g : gamesList) {

            if (g.getId() == id) return g;
        }

        System.out.println("Non ci sono giochi corrispondenti ad id: " + id);
        return null;
    }


}


