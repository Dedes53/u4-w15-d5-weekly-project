package federicolepore;

import federicolepore.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // games
        //videogames
        Games v1 = new VideoGames(11111, "Super Mario", 1985, 50.0, "Nintendo", 5.0, Genres.PLATFORM);
        Games v2 = new VideoGames(11112, "Battlefield 6", 2025, 80.0, "Play Station 5", 10.0, Genres.FPS);
        Games v3 = new VideoGames(11113, "Call of Duty: Black Ops 7", 2025, 70.0, "Xbox series X", 9.0, Genres.FPS);
        Games v4 = new VideoGames(11114, "Assassin's Creed 2", 2009, 20.0, "Play Station 3", 40.0, Genres.ACTION);
        Games v5 = new VideoGames(11115, "The Elder Scrolls V: Skyrim", 2011, 20.0, "Xbox 360", 150.0, Genres.RPG);

        //boardgames
        Games b1 = new BoardGames(11121, "Le Catacombe di Karak", 2017, 30.0, Players.CINQUE, 45.0);
        Games b2 = new BoardGames(11122, "Carcassonne", 2000, 25.0, Players.OTTO, 40.0);
        Games b3 = new BoardGames(11123, "Ticket to Ride", 2004, 35.0, Players.CINQUE, 60.0);
        Games b4 = new BoardGames(11124, "Scythe", 2016, 90.0, Players.SETTE, 115.0);
        Games b5 = new BoardGames(11125, "Munchkin", 2001, 25.0, Players.SEI, 60.0);

        List<Games> gamesList = new ArrayList<>(List.of(v1, v2, v3, v4, v5, b1, b2, b3, b4));

        GamesCollection collection = new GamesCollection(gamesList);

        //prova dei metodi GamesCollection
        collection.getGamesList().forEach(games -> System.out.println(games.toString()));
        System.out.println();
        collection.addGame(b5);
        System.out.println();
        System.out.println(collection.searchById(11125));
        System.out.println();
        collection.getGamesList().forEach(g -> System.out.println(g.toString()));
        System.out.println();
        collection.searchByPrice(40.0).forEach(g -> System.out.println(g.toString()));

    }
}
