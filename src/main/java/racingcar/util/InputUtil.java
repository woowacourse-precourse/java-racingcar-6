package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public static int readInt() {
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public static String[] readLine(){
        String input = Console.readLine();
        String[] car = input.split(",");

        return car;
    }
}
