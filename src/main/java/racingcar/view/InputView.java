package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    public static void getRacingCars() {
        String input = Console.readLine();
        InputValidator.validateCarsFormat(input);
        InputValidator.validateCarLength(input);
    }

    public static void getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
    }
}