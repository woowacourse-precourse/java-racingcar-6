package racingcar.preprocess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProcessNamesTest {
    @Test
    public void testProcessNames() {
        ProcessNames processNames = new ProcessNames();

        String inputCarName = "pobi, woni, jun";

        List<String> expected = Arrays.asList("pobi", "woni", "jun");

        List<String> result = processNames.processNames(inputCarName);
        assertEquals(expected, result);
    }
}