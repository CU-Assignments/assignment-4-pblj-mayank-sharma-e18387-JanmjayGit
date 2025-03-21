import java.util.*;

class Card {
    private String symbol;
    private String value;

    // Constructor
    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    // Getters
    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    // Display Card Details
    public void displayCard() {
        System.out.println("Symbol: " + symbol + ", Value: " + value);
    }
}

public class CardCollection {
    private static HashMap<String, List<Card>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== Card Collection System =====");

        // Add cards to the collection
        System.out.print("Enter number of cards to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Card " + i + ":");
            System.out.print("Symbol (e.g., Hearts, Spades): ");
            String symbol = scanner.nextLine();
            System.out.print("Value (e.g., A, 2, King): ");
            String value = scanner.nextLine();

            Card card = new Card(symbol, value);
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }

        // Search for cards by symbol
        System.out.print("\nEnter symbol to search cards: ");
        String searchSymbol = scanner.nextLine();

        if (cardMap.containsKey(searchSymbol)) {
            List<Card> cards = cardMap.get(searchSymbol);
            System.out.println("\nCards with symbol '" + searchSymbol + "':");
            for (Card c : cards) {
                c.displayCard();
            }
        } else {
            System.out.println("No cards found with the symbol '" + searchSymbol + "'.");
        }
    }
}
