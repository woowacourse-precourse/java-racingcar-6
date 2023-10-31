package racingcar.util.validation.InputValidator;

import java.util.List;
import java.util.stream.Stream;

public class InputValidator {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_DELIMITER_MESSAGE = "쉼표(,)를 이용하여 이름을 구분해주세요";
    private static final int TRY_NUM_STANDARD = 0;
    private static final int NAME_LIMIT = 5;

    public static void validateUserInput(String userInput) {
        isSplit(userInput);
    }

    private static void isSplit(String userInput) {
        if (!userInput.contains(",")) {
            System.out.println(ERROR_MESSAGE + REQUEST_DELIMITER_MESSAGE);
            throw new IllegalArgumentException();
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

                throw new IllegalArgumentException();
            }
        }
    }

    public static void isLongerThanNameLimit(List<String> userInputList) {
        for (String carName : userInputList) {
            if (carName.length() > NAME_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isDuplicated(List<String> userInputList) {
        Stream<String> streamList = userInputList.stream();
        Stream<String> distinctList = streamList.distinct();
        long distinctListSize = distinctList.count();
        if (userInputList.size() != distinctListSize) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
    }

    private static void isPositiveNum(int racingRound) {
        if (racingRound <= TRY_NUM_STANDARD) {
            throw new IllegalArgumentException();
        }
    }
}
