package racingcar.domain;

import static racingcar.consts.ErrorMessages.DUPLICATION_CAR_NAME_MESSAGE;
import static racingcar.consts.ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE;
import static racingcar.consts.ErrorMessages.WRONG_CAR_TYPES_MESSAGE;
import static racingcar.consts.ErrorMessages.WRONG_NUMBER_OF_ATTEMPT_MESSAGE;
import static racingcar.consts.GameConstant.MAX_LENGTH_CAR_NAME;
import static racingcar.consts.GameConstant.MIN_LENGTH_CAR_NAME;
import static racingcar.consts.GameConstant.MIN_NUMBER_TYPES_CAR;
import static racingcar.consts.ViewConstant.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern numericPattern = Pattern.compile("^[1-9]\\d*$");

    public void validateCarNames(String playerInput) {
        List<String> carNames = splitInput(playerInput);
        validateCarNameLength(carNames);
        validateDuplicateCarNames(carNames);
        validateCarTypesCount(carNames);
    }

    public void validateNumberOfAttempt(String playerInput) {
        if (!isNumeric(playerInput)) {
            throwException(WRONG_NUMBER_OF_ATTEMPT_MESSAGE.get());
        }
    }

    private List<String> splitInput(String playerInput) {
        return Arrays.stream(playerInput.split(DELIMITER.get()))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCarNameLength(List<String> carNames) {
        if (!carNames.stream().allMatch(this::isCarNameLengthValid)) {
            throwException(WRONG_CAR_NAME_LENGTH_MESSAGE.get());
        }
    }

    private boolean isCarNameLengthValid(String carName) {
        int length = carName.length();
        return length >= MIN_LENGTH_CAR_NAME.get() && length <= MAX_LENGTH_CAR_NAME.get();
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throwException(DUPLICATION_CAR_NAME_MESSAGE.get());
        }
    }

    private void validateCarTypesCount(List<String> carNames) {
        if (carNames.size() < MIN_NUMBER_TYPES_CAR.get()) {
            throwException(WRONG_CAR_TYPES_MESSAGE.get());
        }
    }

    private boolean isNumeric(String playerInput) {
        return numericPattern.matcher(playerInput).matches();
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
