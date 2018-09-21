import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerClient {

    private List<Card> hand;

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        hand = Stream.of(p1, p2, p3, p4, p5).map(Card::new).collect(Collectors.toList());
    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        int opposingHighest = Stream.of(p1, p2, p3, p4, p5).map(Card::new).mapToInt(Card::getValue).max().getAsInt();

        return hand.stream().mapToInt(Card::getValue).anyMatch(card -> card > opposingHighest);
    }

}