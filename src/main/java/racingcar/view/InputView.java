package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public static List<String> inputCarNames() {
        String names = Console.readLine();
        InputValidator.isValidCarName(names);
        List<String> namesList = List.of(names.split(","));
        return namesList;
    }

    public static int inputAttempts() {
        String input = Console.readLine();
        InputValidator.isValidAttempts(input);
        return Integer.parseInt(input);
    }
}
