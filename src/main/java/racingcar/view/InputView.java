package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.InputValidator;

import java.util.Arrays;

public class InputView {
    private static final String REGEX = ",";

    private static final InputValidator inputValidator = new InputValidator();

    public Cars readCarNames() {
        String input = Console.readLine();
        inputValidator.validateIsSplitByComma(input);
        return new Cars(Arrays.stream(input.split(REGEX)).map(Car::new).toList());
    }

    public int readAttemptCount() {
        String input = Console.readLine();
        inputValidator.validateIsDigit(input);
        return Integer.parseInt(input);
    }
}
