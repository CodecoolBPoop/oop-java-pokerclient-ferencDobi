import java.util.HashMap;
import java.util.Map;

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

        if (!cardCode.matches("[SCDHscdh].+"))
            throw new IllegalArgumentException("card color isn't valid: " + cardCode.substring(0, 1));

        String cardValue = cardCode.substring(1).toUpperCase();
        int intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10 || intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
        }

        this.cardCode = cardCode;
    }

    public int getValue() {

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardCode.substring(1).toUpperCase());
        }

        return intCardValue;
    }
}
