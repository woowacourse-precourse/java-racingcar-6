package racingcar.view;


import static racingcar.enums.OutputMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.enums.OutputMessage.ROUND_RESULT_MESSAGE;
import static racingcar.enums.OutputMessage.TRY_COUNT_INPUT_MESSAGE;
import static racingcar.enums.OutputMessage.WINNER_MESSAGE;

public class OutputView {

    public static void printCarNameInputMessage() {
        System.out.print(CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printTryCountInputMessage() {
        System.out.print(TRY_COUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printRoundResult(String result) {
        System.out.println();
        System.out.println(ROUND_RESULT_MESSAGE);
        System.out.print(result);
    }

    public static void printWinnerNames(String result) {
        System.out.print(WINNER_MESSAGE.getMessage());
        System.out.print(result);
    }

}
