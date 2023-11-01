package racingcar.global.view;


import static racingcar.global.enums.OutputMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.global.enums.OutputMessage.ROUND_RESULT_MESSAGE;
import static racingcar.global.enums.OutputMessage.TRIAL_INPUT_MESSAGE;
import static racingcar.global.enums.OutputMessage.WINNER_MESSAGE;

public class OutputView {

    public static void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printTrialInputMessage() {
        System.out.println(TRIAL_INPUT_MESSAGE.getMessage());
    }

    public static void printRoundResult(String result) {
        System.out.println();
        System.out.println(ROUND_RESULT_MESSAGE.getMessage());
        System.out.print(result);
    }

    public static void printWinnerNames(String result) {
        System.out.print(WINNER_MESSAGE.getMessage());
        System.out.print(result);
    }

}
