package racingcar.View;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String NEW_LINE = "\n";

    public void printGameResultword() {
        System.out.println(NEW_LINE + GAME_RESULT);
    }

    public void printWinnerView(List<String> winner) {
        // 결과 출력
        String result = String.join(",", winner);
        System.out.println("최종 우승자 : " + result);
    }
}
