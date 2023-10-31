package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringSplitterTest {

    @Test
    public void testSplit() {
        String input = "car1,car2,car3";
        List<String> expected = Arrays.asList("car1", "car2", "car3");
        assertEquals(expected, StringSplitter.split(input, ","));
    }

    @Test
    public void testSplit_EmptyInput() {
        String input = "";
        List<String> expected = Arrays.asList("");
        assertEquals(expected, StringSplitter.split(input, ","));
    }

    @Test
    public void testSplit_NoDelimiter() {
        String input = "car1 car2 car3";
        List<String> expected = Arrays.asList("car1 car2 car3");
        assertEquals(expected, StringSplitter.split(input, ","));
    }
}
