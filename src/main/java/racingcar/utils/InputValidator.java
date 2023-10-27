package racingcar.utils;

import racingcar.constants.ExceptionMessages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 5;
    private static final String SPACING_STRING = " ";
    private static final String EMPTY_STRING = "";

    public String preprocessInputString(String inputString) {
        if (isNull(inputString)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        if (isEmpty(inputString)) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        return removeSpacing(inputString);
    }

    public List<String> validateCarsNameInput(String inputString) {
        if (!isUsingCommaSeperator(inputString)) {
            ExceptionMessages.WRONG_SEPERATOR.throwException();
        }
        List<String> convertedStringList = convertStringToStringList(inputString);
        if (!isOneToFive(convertedStringList)) {
            ExceptionMessages.WRONG_RANGE_CAR_NAME.throwException();
        }
        if (!isNotDuplicated(convertedStringList)) {
            ExceptionMessages.DUPLICATED_CAR_NAMES.throwException();
        }
        return convertedStringList;
    }

    public int validateTrialTimesInput(String inputString) {
        isNumericCastable(inputString);
        if (Integer.parseInt(inputString) < MINIMUM_NUMBER) {
            ExceptionMessages.WRONG_RANGE_NUMBER.throwException();
        }
        return Integer.parseInt(inputString);
    }

    private List<String> convertStringToStringList(String inputString) {
        List<String> carsNameList;
        carsNameList = Stream.of(inputString.split(",")).collect(Collectors.toList());
        return carsNameList;
    }

    private String removeSpacing(String inputString) {
        return inputString.replaceAll(SPACING_STRING, EMPTY_STRING);
    }

    private boolean isNull(String inputString) {
        return inputString == null;
    }

    private boolean isEmpty(String inputString) {
        return inputString == EMPTY_STRING;
    }

    private boolean isOneToFive(List<String> inputStringList) {
        return inputStringList.stream()
                .filter((carName) -> ((carName.length() >= MINIMUM_NUMBER) && (carName.length() <= MAXIMUM_NUMBER)))
                .count() == inputStringList.size();
    }

    private boolean isUsingCommaSeperator(String inputString) {
        return ((inputString.length() > MAXIMUM_NUMBER) && (inputString.contains(",")));
    }

    private boolean isNotDuplicated(List<String> stringList) {
        return stringList.stream()
                .distinct()
                .count() == stringList.size();
    }

    private void isNumericCastable(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            ExceptionMessages.NOT_NUMBER.throwException();
        }
    }
}
