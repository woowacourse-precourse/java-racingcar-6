package racingcar.validation;

import static racingcar.constant.MessageConst.COMMA_MESSAGE;
import static racingcar.constant.MessageConst.DUPLICATE_MESSAGE;
import static racingcar.constant.MessageConst.EMPTY_MESSAGE;
import static racingcar.constant.MessageConst.LENGTH_MESSAGE;
import static racingcar.constant.MessageConst.NULL_MESSAGE;
import static racingcar.constant.MessageConst.SPACE_MESSAGE;
import static racingcar.constant.MessageConst.NUMERIC_FORMAT_MESSAGE;
import static racingcar.constant.MessageConst.RANGE_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class InputValidation {

    public void validateCarNameRange(List<String> carNames) {
        for (String carName : carNames) {
            int carNameLength = carName.length();
            isRangeValid(carNameLength);
        }
    }

    public void isRangeValid(int carNameLength) {
        if (carNameLength < 1 || carNameLength > 5) {
            throw new IllegalArgumentException(LENGTH_MESSAGE);
        }
    }

    public void validateCarNameDuplication(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public void validateCarNameSpace(List<String> carNames) {
        if (hasCarNamesWithSpace(carNames)) {
            throw new IllegalArgumentException(SPACE_MESSAGE);
        }
    }

    private boolean hasCarNamesWithSpace(List<String> carNames) {
        return carNames.stream()
                .anyMatch(carName -> carName.contains(" "));
    }

    public void validateCarNameEmpty(List<String> carNames) {
        if (hasCarNamesWithEmpty(carNames)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private boolean hasCarNamesWithEmpty(List<String> carNames) {
        return carNames.stream()
                .anyMatch(String::isEmpty);
    }

    public void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public void validateCommaSeparatedCarNames(String carNames) {
        if (hasNotCommaSeparatedCarNames(carNames)) {
            throw new IllegalArgumentException(COMMA_MESSAGE);
        }
    }

    private boolean hasNotCommaSeparatedCarNames(String input) {
        return !input.matches(".*[a-zA-Z]+(,[a-zA-Z]+)+.*");
    }

    public void validateCarNames(String input) {
        validateInputNull(input);
        validateCommaSeparatedCarNames(input);
        List<String> carNames = stringToCollection(input);
        validateCarNameRange(carNames);
        validateCarNameDuplication(carNames);
        validateCarNameSpace(carNames);
        validateCarNameEmpty(carNames);
    }

    private List<String> stringToCollection(String input) {
        return Stream.of(input.split(","))
                .toList();
    }

    public void validateInputNumericFormat(String input) {
        if (isNotNumericFormat(input)) {
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE);
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validateInputRange(String input) {
        int inputRange = Integer.parseInt(input);
        if (isNotPositive(inputRange)) {
            throw new IllegalArgumentException(RANGE_MESSAGE);
        }
    }

    private boolean isNotPositive(int inputRange) {
        return inputRange < 1;
    }

    public void validateInputEmpty(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private boolean isEmptyValue(String input) {
        return input.isEmpty();
    }

    public void validateAttemptInput(String input) {
        validateInputNull(input);
        validateInputEmpty(input);
        validateInputNumericFormat(input);
        validateInputRange(input);
    }
}
