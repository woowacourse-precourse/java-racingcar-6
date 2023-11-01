package racingcar.view;

import racingcar.util.MessageUtil;

public class OutputView {
    public void printCarNameInputMessage() {
        MessageUtil.CAR_NAME_INPUT_MESSAGE.messagePrintln();
    }

    public void printTryCountInputMessage() {
        MessageUtil.TRY_COUNT_INPUT_MESSAGE.messagePrintln();
    }

    public void printCarNameAndPosition(String carNameAndPosition) {
        System.out.println(carNameAndPosition);
    }

    public void printWinnerMessage(String winnerCarString) {
        MessageUtil.FINAL_WINNER_MESSAGE.messagePrint();
        System.out.print(winnerCarString);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printPlayingResult() {
        MessageUtil.GAME_PLAYING_RESULT_MESSAGE.messagePrintln();
    }
}
