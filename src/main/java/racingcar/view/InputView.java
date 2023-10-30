package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.AttemptCount;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();
    public Cars readCarNames() {
        String input = Console.readLine();
        return new Cars(Arrays.stream(input.split(",")).map(Car::new).toList());
    }

    public int readAttemptCount() {
        String input = Console.readLine();
        inputValidator.validateIsDigit(input);
        return Integer.parseInt(input);
    }
}
