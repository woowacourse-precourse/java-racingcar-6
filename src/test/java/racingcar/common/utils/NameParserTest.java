package racingcar.common.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class NameParserTest {
    @Test
    void 쉼표단위로_String을_나눠서_배열을_만듭니다() {
        String input = "pobi,woni,jun";
        String[] expected = {"pobi", "woni", "jun"};
        String[] result = NameParser.parseName(input);
        assertArrayEquals(expected, result);
    }
}