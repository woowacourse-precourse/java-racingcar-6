package racingcar;

import java.util.Arrays;
import racingcar.constant.ExceptionMessage;

public class InputValidator {

    /**
     * validate car's name satisfy below <br> - car name should be longer than 5 characters <br> - car name should not
     * empty or blank  <br> - car's name should not be duplicated <br>
     *
     * @param names car's names
     */
    public static void validateCarsName(String[] names) {
        validateDuplication(names);
    }

    private static void validateDuplication(String[] names) {
        int distinctNum = (int) Arrays.stream(names).distinct().count();

        if (distinctNum != names.length) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
    }

    /**
     * validate roundNumberString satisfy below <br> - roundNumberString should be number-format <br> - roundNumber
     * should be positive number <br>
     *
     * @param roundNumberString round number in String
     */
    public static void validateRoundNumber(String roundNumberString) {
        int roundNumber;
        try {
            roundNumber = Integer.parseInt(roundNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
        }

        if (roundNumber <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
        }
    }
}
