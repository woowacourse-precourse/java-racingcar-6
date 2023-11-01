package Util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public static String getUserInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
