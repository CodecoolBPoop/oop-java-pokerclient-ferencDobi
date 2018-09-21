import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Card {

    String cardCode;
    private static Map<String, Integer> alphabeticCardValue = new HashMap<>();
    static {
        alphabeticCardValue.put("J", 11);
        alphabeticCardValue.put("Q", 12);
        alphabeticCardValue.put("K", 13);
        alphabeticCardValue.put("A", 14);
    }

    public Card(String cardCode) throws IllegalArgumentException {
        cardCode = cardCode.toUpperCase();

        if (!cardCode.matches("[SCDH].+"))
            throw new IllegalArgumentException("card color isn't valid: " + cardCode.substring(0, 1));

        String cardValue = cardCode.substring(1);

        if (!alphabeticCardValue.containsKey(cardValue)) {

            // raises exception if cardValue is a letter, but not J/Q/K/A
            int intCardValue = Integer.parseInt(cardValue);

            if (intCardValue > 10 || intCardValue < 2)
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
        }

        this.cardCode = cardCode;
    }

    public int getValue() {
        String cardValue = cardCode.substring(1);

        return Optional.ofNullable(alphabeticCardValue.get(cardValue)).orElseGet(() -> Integer.parseInt(cardValue));
    }
}
