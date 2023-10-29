package racingcar.view.output;

import racingcar.contant.GameNotice;
import utils.Console;

public class OutputView {
    public static void printGameNotice(GameNotice notice) {
        Console.print(notice.getMessage());
    }
//    public static void printMiddleResult() {}
//
//    public static void printWinner() {
//        printGameNotice(GameNotice.NOTICE_WINNER_RESULT);
//    }

}
