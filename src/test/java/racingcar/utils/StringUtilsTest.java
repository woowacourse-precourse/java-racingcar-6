package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringUtilsTest {

    @Test
    void splitCarNamesTest() {
        List<String> strings = new ArrayList<>();

        strings.add("1");
        strings.add("2");
        strings.add("3");

        assertEquals(StringUtils.splitCarNames("1,2,3"), strings);
    }

    @Test
    void joinWinnerCarNameTest() {
        List<String> winnerNames = new ArrayList<>();
        winnerNames.add("pobi");
        winnerNames.add("woni");

        assertEquals("pobi, woni", StringUtils.joinWinnerCarName(winnerNames));
    }
}
