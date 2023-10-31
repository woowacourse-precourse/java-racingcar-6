package racingcar.util.validation.InputValidator;

import java.util.List;
import java.util.stream.Stream;
import racingcar.util.message.ErrorMessage;

public class InputValidator {

    private static final int TRY_NUM_STANDARD = 0;
    private static final int NAME_LIMIT = 5;

    public static void validateUserInput(String userInput) {
        isSplit(userInput);
    }

    private static void isSplit(String userInput) {
        if (!userInput.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_DELIMITER.getErrorMessage());
        }
    }

    public static void validateUserInputList(List<String> userInputList) {
        isEmpty(userInputList);
        isLongerThanNameLimit(userInputList);
        isDuplicated(userInputList);
    }

    private static void isEmpty(List<String> userInputList) {
        for (String carName : userInputList) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(
                    ErrorMessage.REQUEST_NOT_EMPTY.getErrorMessage());
            }
        }
    }

    private static void isLongerThanNameLimit(List<String> userInputList) {
        for (String carName : userInputList) {
            if (carName.length() > NAME_LIMIT) {
                throw new IllegalArgumentException(
                    ErrorMessage.REQUEST_NAME_LIMIT.getErrorMessage());
            }
        }
    }

    private static void isDuplicated(List<String> userInputList) {
        Stream<String> streamList = userInputList.stream();
        Stream<String> distinctList = streamList.distinct();
        long distinctListSize = distinctList.count();
        if (userInputList.size() != distinctListSize) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_NOT_DUPLICATED.getErrorMessage());
        }
    }

    public static int validateRacingRound(String inputRacingRound) {
        int racingRound = isInt(inputRacingRound);
        isPositiveNum(racingRound);
        return racingRound;
    }

    private static int isInt(String inputRacingRound) {
        try {
            return Integer.parseInt(inputRacingRound);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_ONLY_POSITIVE_NUMBER.getErrorMessage());
        }
    }

    private static void isPositiveNum(int racingRound) {
        if (racingRound <= TRY_NUM_STANDARD) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_ONLY_POSITIVE_NUMBER.getErrorMessage());
        }
    }
}
