package racingcar.global.view;


import racingcar.global.enums.OutputMessage;

public class OutputView {

    public static void printCarNameInputMessage() {
        System.out.print(OutputMessage.CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printTryCountInputMessage() {
        System.out.print(OutputMessage.TRY_COUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printRoundResult(String result) {
        System.out.println();
        System.out.println(OutputMessage.ROUND_RESULT_MESSAGE.getMessage());
        System.out.print(result);
    }

    public static void printWinnerNames(String result) {
        System.out.print(OutputMessage.WINNER_MESSAGE.getMessage());
        System.out.print(result);
    }

}
