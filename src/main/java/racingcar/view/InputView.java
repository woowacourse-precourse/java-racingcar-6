package racingcar.view;

import static racingcar.exception.RacingCarExceptionType.*;
import static racingcar.view.RacingCarConsole.*;
import static racingcar.view.RacingCarConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("(\\w)+");

    public List<String> readCarNames() {
        print(CAR_NAME_PROMPT);
        String[] splitCarNames = Console.readLine().split(CAR_NAME_DELIMITER);

        List<String> carNames = Arrays.stream(splitCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
        validateCarNames(carNames);
        return carNames;
    }

    public int readNumberOfAttempts() {
        print(ATTEMPTS_PROMPT);
        String input = Console.readLine();
        validateNumberOfAttempts(input);
        return Integer.parseInt(input);
    }

    private void validateCarNames(List<String> carNames) {
        validateNamesAreNotEmpty(carNames);
        validateNoDuplicateNames(carNames);
        validateCarNameFormat(carNames);
    }

    private void validateNamesAreNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    private void validateNoDuplicateNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    private void validateCarNameFormat(List<String> carNames) {
        for (String carName : carNames) {
            if (!CAR_NAME_PATTERN.matcher(carName).matches()) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage());
            }
        }
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
