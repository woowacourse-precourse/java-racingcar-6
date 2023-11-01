package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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

    @Test
    void concatNamesByCommas() {assertEquals("pobi, woni, jun", StringUtil.concatNamesByCommas(Arrays.asList("pobi", "woni", "jun")));
    }
}