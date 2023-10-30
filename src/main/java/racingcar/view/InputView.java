package racingcar.view;

import static racingcar.exception.RacingCarExceptionType.INVALID_TRY_COUNT_FORMAT;
import static racingcar.exception.RacingCarExceptionType.NON_POSITIVE_TRY_COUNT;
import static racingcar.view.RacingCarConsole.print;
import static racingcar.view.RacingCarConstants.ATTEMPTS_PROMPT;
import static racingcar.view.RacingCarConstants.CAR_NAME_DELIMITER;
import static racingcar.view.RacingCarConstants.CAR_NAME_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarNames;

public class InputView {

    public CarNames readCarNames() {
        print(CAR_NAME_PROMPT);
        String[] splitCarNames = Console.readLine().split(CAR_NAME_DELIMITER);
        List<String> carNames = Arrays.stream(splitCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
        return new CarNames(carNames);
    }

    public int readNumberOfAttempts() {
        print(ATTEMPTS_PROMPT);
        String input = Console.readLine();
        validateNumberOfAttempts(input);
        return Integer.parseInt(input);
    }

    private void validateNumberOfAttempts(String attemptsInput) {
        try {
            int attempts = Integer.parseInt(attemptsInput);
            validatePositiveNumberOfAttempts(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_FORMAT.getMessage());
        }
    }

    private void validatePositiveNumberOfAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_TRY_COUNT.getMessage());
        }
    }

}
