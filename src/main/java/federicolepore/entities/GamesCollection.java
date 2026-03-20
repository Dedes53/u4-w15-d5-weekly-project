package federicolepore.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GamesCollection {

    //   attributi
    private List<Games> gamesList = new ArrayList<>();

    //   costruttore
    public GamesCollection(List games) {
        this.gamesList = games;
    }

    public List<Games> getGamesList() {
        return gamesList;
    }

    //   metodi
    public void addGame(Games game) {

        if (game == null) throw new IllegalArgumentException("Devi provare ad aggiungere un gioco, non aria");
        boolean idIsDifferent = gamesList.stream().noneMatch(g -> g.getId() == game.getId());

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

    public List<Games> searchByPrice(double price) {
        // parto da gamesList, filtro i g con un prezzo minore di price, ordino e restituisco la lista
        return gamesList.stream().filter(g -> g.getPrice() < price)
                .sorted(Comparator.comparingDouble(Games::getPrice)).toList();
    }


}


