import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerClient {

    private List<Card> hand;

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        hand = Stream.of(p1, p2, p3, p4, p5).map(Card::new).collect(Collectors.toList());
    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        Card highestCard = new Card("s2");
        List<Card> opposingHand = Stream.of(p1, p2, p3, p4, p5).map(Card::new).collect(Collectors.toList());


        for (int i = 0; i < opposingHand.size(); i++) {
            Card ownCard = hand.get(i);
            for (int j = 0; j < opposingHand.size(); j++) {
                Card opposingCard = opposingHand.get(j);
                if (opposingCard.getValue() >= ownCard.getValue()) {
                    if (opposingCard.getValue() >= highestCard.getValue()) {
                        highestCard = opposingCard;
                    }
                } else {
                    if (ownCard.getValue() > highestCard.getValue()) {
                        highestCard = ownCard;
                    }
                }
            }
        }

        return hand.contains(highestCard);
    }

}