package utils;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;

public class InputUtil {
    public static void setInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    public static void closeConsole() {
        Console.close();
    }
}
