package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public static List<String> getRacingCars() {
        String input = Console.readLine();
        List<String> inputs = InputValidator.validateCarsFormat(input);
        InputValidator.validateUniqueCarName(inputs);
        InputValidator.validateCarNameValid(inputs);
        return inputs;
    }

    public static int getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
        return Integer.parseInt(input);
    }
}