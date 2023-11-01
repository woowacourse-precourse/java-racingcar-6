package racingcar;

import static racingcar.Constant.CAR_NAMES_DELIMITER;
import static racingcar.Constant.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.Constant.MAXIMUM_TRY_COUNT;
import static racingcar.Constant.MINIMUM_CAR_COUNT;
import static racingcar.Constant.MINIMUM_CAR_NAME_LENGTH;
import static racingcar.Constant.MINIMUM_TRY_COUNT;
import static racingcar.Constant.WHITESPACE_PATTERN;
import static racingcar.ErrorMessage.BLANK_ERROR_MESSAGE;
import static racingcar.ErrorMessage.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.ErrorMessage.CAR_NAME_DELIMITER_ERROR_MESSAGE;
import static racingcar.ErrorMessage.CAR_NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.ErrorMessage.TRY_COUNT_NUMERIC_ERROR_MESSAGE;
import static racingcar.ErrorMessage.TRY_COUNT_RANGE_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return carNames;
    }

    public int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    protected void validateCarNames(String carNames) {
        List<String> nameList = List.of(carNames.split(CAR_NAMES_DELIMITER));
        validateNotBlank(carNames);
        validateNotEndWithDelimiter(carNames);
        validateMinimumCount(nameList);
        nameList.forEach(this::validateEachName);
        validateNotDuplicated(nameList);
    }

    protected void validateTryCount(String tryCount) {
        validateNotBlank(tryCount);
        validateInputIsNumeric(tryCount);
        validateInputInRange(tryCount);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile(WHITESPACE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateNotEndWithDelimiter(String carNames) {
        if (carNames.endsWith(CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(CAR_NAME_DELIMITER_ERROR_MESSAGE);
        }
    }

    private void validateMinimumCount(List<String> inputList) {
        if (inputList.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateEachName(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private void validateLength(String input) {
        if (input.length() < MINIMUM_CAR_NAME_LENGTH || input.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateNotDuplicated(List<String> inputList) {
        if (inputList.stream().distinct().count() != inputList.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateInputInRange(String input) {
        int tryCount = Integer.parseInt(input);
        if (tryCount < MINIMUM_TRY_COUNT || tryCount > MAXIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }
}