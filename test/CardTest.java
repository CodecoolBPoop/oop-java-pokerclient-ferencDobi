import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

class CardTest {

    @Test
    void constructorThrowsExceptionWhenProvidedWithIllegalColor() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Card("Z5"));
        assertTrue(thrown.getMessage().matches(".*color.*"));
    }

    @Test
    void constructorThrowsExceptionWhenProvidedWithIllegalLetterForValue() {
        assertThrows(NumberFormatException.class, () -> new Card("SZ"));
    }

    @Test
    void constructorThrowsExceptionWhenProvidedWithIllegalNumber() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Card("S11"));
        assertTrue(thrown.getMessage().matches(".*number.*"));
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