package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.AttemptCount;
import racingcar.domain.Car;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();
    public List<Car> readCarNames() {
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).map(Car::new).toList();
    }

    public AttemptCount readAttemptCount() {
        String input = Console.readLine();
        inputValidator.validateIsDigit(input);
        return new AttemptCount(Integer.parseInt(input));
    }
}
