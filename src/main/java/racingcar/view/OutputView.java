package racingcar.view;

import java.util.List;

public class OutputView {
    private final static String resultMessage = "실행 결과";
    private final static String winnerMessage = "최종 우승자";

    public void getRacingResult(String racingResult) {
        System.out.print("\n" + resultMessage);
        System.out.println(racingResult);
    }

    public void getWinnerMessage(List<String> winnerList) {
        String winner = winnerMessage + " : " + String.join(", ", winnerList);
        System.out.println(winner);
    }
}
