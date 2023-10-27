package racingcar.model;

import static racingcar.exception.ExceptionMessage.INVALID_CAR_INPUT_ERROR;
import static racingcar.exception.ExceptionMessage.INVALID_CAR_NAME_LENGTH_ERROR;
import static racingcar.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER_ERROR;
import static racingcar.exception.ExceptionMessage.INVALID_INPUT_NOT_INTEGER_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public int validateInputNumber(String roundsInput) {
        validateNumeric(roundsInput);

        return Integer.parseInt(roundsInput);
    }

    private void validateNumeric(String roundsInput) {
        if (!roundsInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_INTEGER_ERROR.getErrorMessage());
        }
    }

    public List<String> splitAndValidateCarNames(String carNames) {
        List<String> nameList = Arrays.stream(carNames.split(","))
                .filter(name -> !name.trim().isEmpty())
                .collect(Collectors.toList());

        validateCarName(nameList);

        return nameList;
    }

    private void validateCarName(List<String> nameList) {
        validateCarNameEmpty(nameList);
        validateCarNameLength(nameList);
        validateDuplicateName(nameList);
    }

    private void validateCarNameEmpty(List<String> nameList) {
        if (nameList.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_INPUT_ERROR.getErrorMessage());
        }
    }

    private void validateCarNameLength(List<String> nameList) {
        nameList.stream()
                .filter(name -> name.isEmpty() || name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR.getErrorMessage());
                });
    }

    private void validateDuplicateName(List<String> nameList) {
        long count = nameList.stream().distinct().count();

        if (count != nameList.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER_ERROR.getErrorMessage());
        }
    }

}
