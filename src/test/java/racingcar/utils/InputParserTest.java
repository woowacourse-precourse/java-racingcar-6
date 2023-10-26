package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void parseCarNames_쉼표가_없을_때() {
        String input = "pobi";
        List<String> expected = Arrays.asList("pobi");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void parseCarNames_쉼표로_여러_분리가_있을_때() {
        String input = "pobi,woni,jun";
        List<String> expected = Arrays.asList("pobi", "woni", "jun");
        List<String> result = InputParser.parseCarNames(input);
        assertEquals(expected, result);
    }

    @Test
    void parseCarNames_빈_문자열() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input);
        });
    }

    @Test
    void parseCarNames_빈_문자열_포함_목록() {
        String input1 = ",pobi,jun";
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input1);
        });
        String input2 = "pobi, ,jun";
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input2);
        });
    }

    @Test
    void parseCarNames_연속_컴마() {
        String input = "pobi,,jun,aa";
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCarNames(input);
        });
    }

}