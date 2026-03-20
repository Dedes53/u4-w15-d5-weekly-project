package federicolepore.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GamesCollection {

    //   attributi
    private List<Games> gamesList = new ArrayList<>();

    //   costruttore
    public GamesCollection(List games) {
        this.gamesList = new ArrayList<>(games);
    }

    public static void printList(List<?> list) {
        if (list == null) {
            System.out.println("Non stai stampando nessuna lista");
            return;
        }
        list.forEach(System.out::println);
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

    public void removeById(long id) {
        boolean removed = gamesList.removeIf(g -> g.getId() == id);
        if (!removed) throw new IllegalArgumentException("Non si può rimuovere ciò che non c'è");
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

    public List<Games> searchByPlayers(int n) {
        return gamesList.stream().
                filter(g -> (g instanceof BoardGames bg) && bg.getPlayers() >= n)
                .toList();
    }

    public void modifyById(long id, Games newGame) {
        if (newGame == null) {
            throw new IllegalArgumentException("Il nuovo gioco non può essere null");
        }
        if (newGame.getId() != id) {
            throw new IllegalArgumentException("L'id del nuovo gioco deve essere: " + id);
        }

        boolean exists = gamesList.stream().anyMatch(g -> g.getId() == id);
        if (!exists) {
            throw new IllegalArgumentException("Non ci sono giochi con id: " + id);
        }

        gamesList = gamesList.stream()
                .map(g -> g.getId() == id ? newGame : g)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public String statCollection() {
        int videoGames = gamesList.stream().filter(g -> g instanceof VideoGames).toList().size();
        int boardGames = gamesList.stream().filter(g -> g instanceof BoardGames).toList().size();
        Optional<Games> mostExpensive = gamesList.stream().max(Comparator.comparing(Games::getPrice));
        double media = gamesList.stream().map(Games::getPrice).reduce(0.0, Double::sum) / gamesList.size();

        return "Nella collezzione al momento ci sono: " + videoGames + " videogames e "
                + boardGames + " boardgames." +
                "\nIl gioco più costoso in collezzione è: " + mostExpensive.get().getTitle() + "." +
                "\nIn media i tuoi giochi valgono: " + media;
    }

}


