package federicolepore;

import federicolepore.entities.*;

import java.util.ArrayList;
import java.util.List;
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
                            "Mostra -> mostra tutta la tua collezione di giochi\n" +
                            "Statistiche -> un brevissimo riassunto della tua collezione\n" +
                            "Esci -> esci dalla tua collezione ");

            String comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "aggiungi":
                    System.out.println("Disponibili da aggiungere sono rimasti b5 o b6, dimmi quale dei due desideri aggiungere?");
                    String game = scanner.nextLine().trim().toLowerCase();
                    switch (game) {
                        case "b5":
                            collection.addGame(b5);
                            break;
                        case "b6":
                            collection.addGame(b6);
                            break;
                        default:
                            System.out.println("Questo nuovo titolo al momento non può essere aggiunto");
                    }
                    break;
                case "rimuovi":
                    System.out.println("Questi sono gli indici disponibili per la rimozione, scegline uno:\n" +
                            "11111, 11112, 11113, 11115, 11121, 11122, 11123, 11124, 11125");
                    String i = scanner.nextLine().trim();
                    switch (i) {
                        case "11111":
                            collection.removeById(11111);
                            break;
                        case "11112":
                            collection.removeById(11112);
                            break;
                        case "11113":
                            collection.removeById(11113);
                            break;
                        case "11114":
                            collection.removeById(11114);
                            break;
                        case "11115":
                            collection.removeById(11115);
                            break;
                        case "11121":
                            collection.removeById(11121);
                            break;
                        case "11122":
                            collection.removeById(11122);
                            break;
                        case "11123":
                            collection.removeById(11123);
                            break;
                        case "11124":
                            collection.removeById(11124);
                            break;
                        case "11125":
                            collection.removeById(11125);
                            break;
                        default:
                            System.out.println("L'indice che hai inserito non è valido");
                            break;
                    }
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
                case "mostra":
                    collection.getGamesList().forEach(System.out::println);
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
