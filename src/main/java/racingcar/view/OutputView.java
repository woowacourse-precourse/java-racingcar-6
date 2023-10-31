package racingcar.view;

import racingcar.util.ViewMessage;

public class OutputView {

    public void printNameAndRecord(String result) {
        System.out.println(ViewMessage.RESULT_MESSAGE.get());
        System.out.println(result);
    }

    public void printWinnerName(String winnerName) {
        System.out.print(ViewMessage.WINNER_MESSAGE.get());
        System.out.println(winnerName);
    }
}
