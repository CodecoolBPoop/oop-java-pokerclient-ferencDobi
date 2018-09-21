import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getValueConvertsLetterToCorrectValue() {
        assertEquals(11, new Card("DJ").getValue());
        assertEquals(13, new Card("SK").getValue());
    }

}