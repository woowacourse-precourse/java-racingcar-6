package racingcar.request;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constants.ErrorConstants.NOT_DIGIT_ERROR_MESSAGE;

public class RequestChecker {

    public static String[] requestNames() {
        return Console.readLine().split(",");
    }

    public static int getNumberOfMovementAttempts(){
        String movementAttempts = Console.readLine();
        return parseInt(movementAttempts);
    }

    private static int parseInt(String movementAttempts) {
        try {
            return Integer.parseInt(movementAttempts);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
        }
    }
}
