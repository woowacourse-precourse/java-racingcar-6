package racingcar;

public class OutputView implements RacingCarGameText {

    private static void printOutput(String outputMessage) {
        System.out.println(outputMessage);
    }

    public static void printRequestMultipleCarName() {
        printOutput(RACINGCAR_REQUEST_MULTIPLE_CAR_NAME);
    }

    public static void printRequestTryCount() {
        printOutput(RACINGCAR_REQUEST_TRY_COUNT);
    }

    public static void printExecuteResult() {
        printOutput(RACINGCAR_EXECUTE_RESULT);
    }

    public static void printFormatFinalWinner(String winner) {
        printOutput(String.format(RACINGCAR_FORMAT_FINAL_WINNER, winner));
    }

    public static void printFormatStatus(String carName, String carDistance) {
        if (carDistance.isBlank()){
            carDistance = RACINGCAR_DOES_NOT_MOVE;
        }
        printOutput(String.format(RACINGCAR_FORMAT_STATUS, carName, carDistance));
    }
}