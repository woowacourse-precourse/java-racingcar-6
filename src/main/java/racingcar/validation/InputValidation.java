package racingcar.validation;

import static racingcar.enumType.message.ExceptionMessage.COMMA_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.DUPLICATE_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.EMPTY_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.LENGTH_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.NULL_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.SPACE_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.NUMERIC_FORMAT_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.number.NumberConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.enumType.number.NumberConstant.CAR_NAME_MIN_LENGTH;
import static racingcar.enumType.number.NumberConstant.RACE_MIN_ROUND;

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
        if (carNameLength < CAR_NAME_MIN_LENGTH.getValue()
                || carNameLength > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    public void validateCarNameDuplication(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE.getValue());
        }
    }

    public void validateCarNameSpace(List<String> carNames) {
        if (hasCarNamesWithSpace(carNames)) {
            throw new IllegalArgumentException(SPACE_MESSAGE.getValue());
        }
    }

    private boolean hasCarNamesWithSpace(List<String> carNames) {
        return carNames.stream()
                .anyMatch(carName -> carName.contains(" "));
    }

    public void validateCarNameEmpty(List<String> carNames) {
        if (hasCarNamesWithEmpty(carNames)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE.getValue());
        }
    }

    private boolean hasCarNamesWithEmpty(List<String> carNames) {
        return carNames.stream()
                .anyMatch(String::isEmpty);
    }

    public void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE.getValue());
        }
    }

    public void validateCommaSeparatedCarNames(String carNames) {
        if (hasNotCommaSeparatedCarNames(carNames)) {
            throw new IllegalArgumentException(COMMA_MESSAGE.getValue());
        }
    }

    private boolean hasNotCommaSeparatedCarNames(String input) {
        String[] carNames = input.split(",");
        return carNames.length < 2;
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
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE.getValue());
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validateInputRange(String input) {
        int inputRange = Integer.parseInt(input);
        if (isNotPositive(inputRange)) {
            throw new IllegalArgumentException(RANGE_MESSAGE.getValue());
        }
    }

    private boolean isNotPositive(int inputRange) {
        return inputRange < RACE_MIN_ROUND.getValue();
    }

    public void validateInputEmpty(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE.getValue());
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
