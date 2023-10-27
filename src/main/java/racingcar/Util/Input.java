package racingcar.Util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private Input() {

    }

    public static List<String> getCars() {
        String input = Console.readLine();

        input = input.replace(" ", "");

        return Arrays.stream(input.split(",")).toList();
    }

    public static int getAttempts() {
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
