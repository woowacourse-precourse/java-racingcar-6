package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    public static String getRacingCars() {
        String input = Console.readLine();
        InputValidator.validateCarsFormat(input);
        InputValidator.validateCarLength(input);
        return input;
    }

    public static String getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
        return input;
    }
}