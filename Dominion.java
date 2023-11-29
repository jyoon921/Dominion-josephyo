import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DominionCard {
    String name;
    int cost;

    DominionCard(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

class DominionPlayer {
    String name;
    int actions;
    int buys;
    int coins;
    List<DominionCard> hand;
    List<DominionCard> deck;
    List<DominionCard> discard;

    DominionPlayer(String name) {
        this.name = name;
        this.actions = 1;
        this.buys = 1;
        this.coins = 0;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
    }

    void draw(int numCards) {
        for (int i = 0; i < numCards; i++) {
            if (deck.isEmpty()) {
                // Shuffle discard into the deck if the deck is empty
                shuffleDeck();
            }

            if (!deck.isEmpty()) {
                DominionCard drawnCard = deck.remove(deck.size() - 1);
                hand.add(drawnCard);
            }
        }
    }

    void shuffleDeck() {
        Collections.shuffle(discard);
        deck.addAll(discard);
        discard.clear();
    }
}

class DominionGame {
    List<DominionCard> kingdomCards;
    List<DominionPlayer> players;

    DominionGame(List<DominionCard> kingdomCards, List<DominionPlayer> players) {
        this.kingdomCards = kingdomCards;
        this.players = players;
    }

    void play() {
        // Initialize game setup
        for (DominionPlayer player : players) {
            player.draw(5);
        }

        // Main game loop
        while (!isGameOver()) {
            for (DominionPlayer player : players) {
                // Implement player turns here
                // Example: player.takeTurn();
            }
        }

        // Display final scores and determine the winner
        // Example: determineWinner();
    }

    boolean isGameOver() {
        // Implement game end conditions
        // Example: return kingdomCards.isEmpty() || threeSupplyPilesEmpty();
        return false;
    }
}

public class DominionMain {
    public static void main(String[] args) {
        // Initialize kingdom cards and players
        List<DominionCard> kingdomCards = new ArrayList<>();
        // Add kingdom cards to the list

        List<DominionPlayer> players = new ArrayList<>();
        // Add players to the list

        // Create Dominion game instance
        DominionGame game = new DominionGame(kingdomCards, players);

        // Start the game
        game.play();
    }
}
