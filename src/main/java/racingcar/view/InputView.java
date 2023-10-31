package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {
    public static List<String> getRacingCars() {
        String input = Console.readLine();
        InputValidator.validateCarsFormat(input);
        InputValidator.validateUniqueCarName(buildRacingCars(input));
        InputValidator.validateCarNameValid(buildRacingCars(input));
        return buildRacingCars(input);
    }

    public static List<String> buildRacingCars(String input) {
        return List.of(input.split(","));
    }

    public static int getTryNumber() {
        String input = Console.readLine();
        InputValidator.validateTryNumber(input);
        return Integer.parseInt(input);
    }
}