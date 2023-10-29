package racingcar.util;

import static racingcar.constants.ErrorConstants.NOT_DIGIT_ERROR_MESSAGE;

public class Console {

    private Console() {
    }

    public static String[] requestNames() {
        return readLine().split(",");
    }

    public static int getNumberOfMovementAttempts() {
        String movementAttempts = readLine();
        return parseInt(movementAttempts);
    }

    private static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    private static int parseInt(String movementAttempts) {
        try {
            return Integer.parseInt(movementAttempts);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
        }
    }

}
