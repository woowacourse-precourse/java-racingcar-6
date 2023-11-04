package racingcar.util;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    public void 문자열_분리() {
        String input = "김명준, 김혜인, 김고운";
        List<String> parts = StringManipulator.split(input);

        assertEquals(3, parts.size());
    }

    @Test
    public void 문자열_병합() {
        List<String> parts = Arrays.asList("김명준", "김혜인", "김고운");
        String result = StringManipulator.join(parts);

        assertEquals("김명준, 김혜인, 김고운", result);
    }
}
