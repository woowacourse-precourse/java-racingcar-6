package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private static final String MSG_RESULT = "\n실행 결과";
    private static final String MSG_WINNER = "최종 우승자 : ";

    private OutputView() {
    }

    public static void printMsgResult() {
        System.out.println(MSG_RESULT);
    }

    public static void printRacingResult(final String racingResult) {
        System.out.println(racingResult);
    }

    public static void printWinner(final String winnerList) {
        System.out.println(MSG_WINNER + winnerList);
    }
}
