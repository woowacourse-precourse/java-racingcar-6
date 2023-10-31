package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputValueValidator {

    public List<String> validateName(String inputCarNames) {
        List<String> carNames = convertStringToList(inputCarNames);

        if (!isDuplicateName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_DUPLICATE.getMessage());
        } else if (!isCarNameLength(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_LENGTH.getMessage());
        } else if (inputCarNames.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_NO_SPACES.getMessage());
        } else if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_IS_NOT_NULL.getMessage());
        } else if (!isMinimumTwoCarNames(carNames)) {
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

    private boolean isMinimumTwoCarNames(List<String> carNames) {
        return carNames.size() > 1;
    }

    private boolean isDuplicateName(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        return set.size() == carNames.size();
    }

    private boolean isCarNameLength(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= 5);
    }

    private List<String> convertStringToList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }
}