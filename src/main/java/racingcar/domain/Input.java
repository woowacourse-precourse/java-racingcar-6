package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> readCarName() {
        String input = Console.readLine();
        String[] Names = input.split(",");
        return Arrays.asList(Names);
    }

    public static int readMoveCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
