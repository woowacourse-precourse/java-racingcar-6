package racingcar.view;

import java.util.ArrayList;
import java.util.Map;

public class OutputView {
    private static final String RESULT_LOG = "실행 결과";
    private static final String MOVING_MARK = "-";
    private static final String ANNOUNCEMENT_OF_WINNER = "최종 우승자 : %s";

    public void showResultLog() {
        System.out.println();
        System.out.println(RESULT_LOG);
    }

    public void showOneRound(Map<String, Integer> gameResult) {
        for(String name : gameResult.keySet()) {
            Integer result = gameResult.get(name);
            System.out.println(name + " : " + MOVING_MARK.repeat(result));
        }
        System.out.println();
    }

    public void showWinners(ArrayList<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf(ANNOUNCEMENT_OF_WINNER, result);
    }
}
