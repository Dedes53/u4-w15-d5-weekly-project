package federicolepore;

import federicolepore.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


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
        Games b6 = new BoardGames(11125, "Descent", 2001, 170.0, Players.QUATTRO, 2400.0);

        List<Games> gamesList = new ArrayList<>(List.of(v1, v2, v3, v4, v5, b1, b2, b3, b4));

        GamesCollection collection = new GamesCollection(gamesList);

        //prova dei metodi GamesCollection
//        collection.getGamesList().forEach(games -> System.out.println(games.toString()));
//        System.out.println();
//        collection.addGame(b5);
//        System.out.println();
//        System.out.println(collection.searchById(11125));
//        System.out.println();
//        collection.getGamesList().forEach(g -> System.out.println(g.toString()));
//        System.out.println();
//        collection.searchByPrice(40.0).forEach(g -> System.out.println(g.toString()));
//        System.out.println();
//        collection.searchByPlayers(8).forEach(g -> System.out.println(g.toString()));
//        System.out.println();
//        collection.removeById(11112);
//        collection.getGamesList().forEach(g -> System.out.println(g.toString()));
//        System.out.println();
//        collection.modifyById(11125, b6);
//        collection.getGamesList().forEach(g -> System.out.println(g.toString()));
//        System.out.println();
//        System.out.println(collection.statCollection());

        boolean isOn = true;
        System.out.println("Ecco la tua colezzione di giochi. Dimmi cosa vuoi fare?");
        while (isOn) {
            System.out.println(
                    "Aggiungi -> aggiungi un nuovo elemento alla tua lista\n" +
                            "Rimuovi -> rimuovi un gioco dalla tua collezione\n" +
                            "Ricerca Id -> cerca il gioco che desideri fornendo l'id\n" +
                            "Ricerca prezzo -> vedi tutti i giochi inferiori al prezzo che hai selezionato\n" +
                            "Ricerca giocatori -> cerca tutti i giochi con cui poter giocare con il tuo numero di amici \n" +
                            "Aggiorna -> aggiorna un elemento della tua lista\n" +
                            "Statistiche -> un brevissimo riassunto della tua collezione\n" +
                            "Esci -> esci dalla tua collezione ");

            String comando = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            switch (comando) {
                case "aggiungi":
                    collection.addGame(b5);
                    break;
                case "rimuovi":
                    collection.removeById(11112);
                    break;
                case "ricerca id":
                    System.out.println(collection.searchById(11124));
                    break;
                case "ricerca prezzo":
                    collection.searchByPrice(40);
                    break;
                case "ricerca giocatori":
                    collection.searchByPlayers(6);
                    break;
                case "aggiorna":
                    collection.modifyById(11125, b6);
                    break;
                case "statistiche":
                    System.out.println(collection.statCollection());
                    break;
                case "esci":
                    isOn = false;
                    break;
                default:
                    System.out.println("Comando non riconosiuto, ti prego di riprovare:");
            }

        }


    }
}
