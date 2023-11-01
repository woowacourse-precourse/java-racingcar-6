package utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.string.StringUtils;

public class Validator {
    private static final int CAR_NAME_RESTRICTIONS_MIN = 1;
    private static final int CAR_NAME_RESTRICTIONS_MAX = 5;
    private static final String EMPTY_SPACE = " ";

    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<String> carNameList = StringUtils.parseCarNames(input);
        checkCarNameDuplicatedAndThrowException(carNameList);
        checkCarNameLengthAndSpaceInputThrowException(carNameList);
    }

    public void checkGameCountInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkIntegerInputAndThrowException(input);
    }

    private void checkCarNameLengthAndSpaceInputThrowException(List<String> carNameList) {
        for (String carName : carNameList) {
            checkCarNameLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);
        }
    }

    private void checkIntegerInputAndThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(input + ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(input + ExceptionMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private void checkCarNameDuplicatedAndThrowException(List<String> carNameList) {
        Set<String> set = new HashSet<>(carNameList);
        if (set.size() != carNameList.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_CARNAME_ERROR.getMessage());
        }
    }

    private void checkLastIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwOutOfLengthException(input);
        }
    }

    private void checkCarNameLengthAndThrowException(String carName) {
        if (CAR_NAME_RESTRICTIONS_MAX < carName.length() ||
                carName.length() < CAR_NAME_RESTRICTIONS_MIN) {
            throwOutOfLengthException(carName);
        }
    }

    private void throwOutOfLengthException(String input) {
        throw new IllegalArgumentException(input + ExceptionMessage.OUT_OF_LENGTH_CARNAME_ERROR.getMessage());
    }


    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(EMPTY_SPACE)) {
            throwEmptySpaceException(carName);
        }
    }

    private void throwEmptySpaceException(String input) {
        throw new IllegalArgumentException(input + ExceptionMessage.EMPTY_SPACE_INCLUDE_ERROR.getMessage());
    }
}
