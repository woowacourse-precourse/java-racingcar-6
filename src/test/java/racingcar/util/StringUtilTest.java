package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void isLengthOverFive() {
        assertTrue(StringUtil.isLengthOverFive("mylengthisoverfive"));
    }

    @Test
    void isBlank() {
        assertTrue(StringUtil.isBlank("   "));
    }

    @Test
    void concatTag() {
        assertEquals("pobi : ", StringUtil.concatTag("pobi"));
    }

    @Test
    void drawLine() {
        assertEquals("---", StringUtil.drawLine(3));
    }
}