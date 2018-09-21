import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerClient {

    private List<Card> hand;

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        hand = Stream.of(p1, p2, p3, p4, p5).map(Card::new).collect(Collectors.toList());
    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        Card hc = new Card("s2");
        List<Card> o = new ArrayList<Card>();
        o.add(new Card(p1.toUpperCase()));
        o.add(new Card(p2.toUpperCase()));
        o.add(new Card(p3.toUpperCase()));
        o.add(new Card(p4.toUpperCase()));
        o.add(new Card(p5.toUpperCase()));


        for (int i = 0; i < o.size(); i++) {
            Card mc = hand.get(i);
            for (int j = 0; j < o.size(); j++) {
                Card oc = o.get(j);
                if (oc.getValue() >= mc.getValue()) {
                    if (oc.getValue() >= hc.getValue()) {
                        hc = oc;
                    }
                } else {
                    if (mc.getValue() > hc.getValue()) {
                        hc = mc;
                    }
                }
            }
        }

        return hand.contains(hc);
    }

}