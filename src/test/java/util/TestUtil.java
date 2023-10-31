package util;

import java.io.ByteArrayInputStream;

public class TestUtil {
    public static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
