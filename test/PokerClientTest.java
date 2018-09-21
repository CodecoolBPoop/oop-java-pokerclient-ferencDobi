import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {
    private PokerClient client1 = new PokerClient("h3", "d2", "s3", "s4", "cq");
    private PokerClient client2 = new PokerClient("cq", "d2", "s3", "s4", "h3");

    @Test
    void highestCardIsMineReturnsTrueWhenInvokingObjectHasHighestCardWithHigherValue() {
        assertTrue(client1.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
        assertTrue(client2.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
    }

    @Test
    void highestCardIsMineReturnsFalseWhenInvokingObjectHasHighestCardWithSameValue() {
        assertFalse(client1.highestCardIsMine("s3", "h4", "s5", "d6", "sq"));
        assertFalse(client2.highestCardIsMine("s3", "h4", "s5", "d6", "sq"));
    }

    @Test
    void highestCardIsMineReturnsFalseWhenInvokingObjectHasHighestCardWithLowerValue() {
        assertFalse(client1.highestCardIsMine("s3", "h4", "s5", "d6", "sk"));
        assertFalse(client2.highestCardIsMine("s3", "h4", "s5", "d6", "sk"));
    }

}