import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

class CardTest {

    @Test
    void constructorThrowsExceptionWhenProvidedWithIllegalColor() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Card("Z5"));
        assertEquals("card color isn't valid: Z", thrown.getMessage());
    }

    @Test
    void constructorThrowsExceptionWhenProvidedWithIllegalLetterForValue() {
        assertThrows(NumberFormatException.class, () -> new Card("SZ"));
    }

    @Test
    void constructorThrowsExceptionWhenProvidedWithOutOfBoundsNumber() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Card("S11"));
        assertEquals("card number isn't valid: 11", thrown.getMessage());
        thrown = assertThrows(IllegalArgumentException.class, () -> new Card("S1"));
        assertEquals("card number isn't valid: 1", thrown.getMessage());
    }

    @TestFactory
    DynamicTest[] happyPathWorksAsExpected() {
        Card card1 = new Card("DJ");
        Card card2 = new Card("SK");
        Card card3 = new Card("C9");

        return new DynamicTest[] {
                dynamicTest("constructorAcceptsValidArguments()", () -> {
                    assertEquals("DJ", card1.cardCode);
                    assertEquals("SK", card2.cardCode);
                    assertEquals("C9", card3.cardCode);
                }),
                dynamicTest("getValueConvertsLetterToCorrectValue()", () -> {
                    assertEquals(11, card1.getValue());
                    assertEquals(13, card2.getValue());
                }),
                dynamicTest("getValueReturnsNumberWhenNoConversionIsNeeded()", () ->
                        assertEquals(9, card3.getValue()))
        };
    }
}