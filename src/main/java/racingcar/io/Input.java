package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import validation.InputValidate;

public class Input {
    public static List<String> carNames() {
        String input = Console.readLine();
        List<String> names = List.of(input.split(","));
        InputValidate.carNames(names);
        return names;
    }

    public static int gameRound() {
        String input = Console.readLine();
        InputValidate.gameRound(input);
        return Integer.parseInt(input);
    }
}
