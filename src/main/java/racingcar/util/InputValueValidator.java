package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.ErrorMessage;

public class InputValueValidator {

    public List<String> validateName(String inputCarNames) {
        List<String> carNames = convertStringToList(inputCarNames);

        if (hasDuplicateName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_DUPLICATE.getMessage());
        }

        if (!isValidCarNameLength(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_LENGTH.getMessage());
        }

        if (inputCarNames.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_NO_SPACES.getMessage());
        }

        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_IS_NOT_NULL.getMessage());
        }

        if (!hasMinimumTwoCarNames(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MINIMUM_NAMES.getMessage());
        }

        return carNames;
    }

    public int validateTryCount(String tryCount) {

        int tryCountNumber = parseTryCount(tryCount);

        if (!isMinimumOneTryCounts(tryCountNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MINIMUM_TRY_COUNT.getMessage());
        }
        return tryCountNumber;
    }

    private int parseTryCount(String tryCount) {
        try {
            return convertStringToInt(tryCount);
        } catch (NumberFormatException ex) {
            if (tryCount.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_TRY_COUNT_IS_NOT_NULL.getMessage());
            }
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_FORMAT_TRY_COUNT.getMessage());
        }
    }

    private int convertStringToInt(String tryCount) {
        return Integer.parseInt(tryCount);
    }

    private boolean isMinimumOneTryCounts(int tryCountNumber) {
        return tryCountNumber > 0;
    }

    private boolean hasMinimumTwoCarNames(List<String> carNames) {
        return carNames.size() > 1;
    }

    private boolean hasDuplicateName(List<String> carNames) {
        Set<String> nameSet = carNames.stream().collect(Collectors.toSet());
        return nameSet.size() != carNames.size();
    }

    private boolean isValidCarNameLength(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= 5);
    }

    private List<String> convertStringToList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }
}