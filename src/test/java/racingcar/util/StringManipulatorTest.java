package racingcar.util;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    public void testSplit() {
        String input = "김명준, 김혜인, 김고운";
        List<String> parts = StringManipulator.split(input);

        assertEquals(3, parts.size());
    }

    @Test
    public void testJoin() {
        List<String> parts = Arrays.asList("김명준", "김혜인", "김고운");
        String result = StringManipulator.join(parts);

        assertEquals("김명준, 김혜인, 김고운", result);
    }
}
