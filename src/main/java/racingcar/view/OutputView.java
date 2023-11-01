package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String MOVING_INDICATORS = "-";

    public String convertListToString(List<String> winnerList) {
        return String.join(", ", winnerList);
    }

    public void showWinners(List<String> winnerList) {
        String winners = convertListToString(winnerList);
        System.out.print("최종 우승자 : " + winners);
    }

    public void showResult(String car, int movingCount) {
        System.out.println(car + " : " + MOVING_INDICATORS.repeat(movingCount));
    }

    public void showDefaultResultSentence() {
        System.out.println("\n실행 결과");
    }
}
