package racingcar.view;

import static racingcar.constant.ConsoleOutputConstants.EXECUTION_RESULT;
import static racingcar.constant.ConsoleOutputConstants.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.constant.ConsoleOutputConstants.INPUT_PLAY_NUMBER_MESSAGE;


public class ConsoleOutput {

    public static void informInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void informInputPlayNumber() {
        System.out.println(INPUT_PLAY_NUMBER_MESSAGE);
    }

    public static void informPlayResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printProgressState(ProgressState progressState) {
        progressState.cars()
                .forEach(car -> {
                    String progressMessage = generateProgressStateMessage(car);
                    System.out.println(progressMessage);
                });
    }

}
