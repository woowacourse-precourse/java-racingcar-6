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

    public static void informExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

}
