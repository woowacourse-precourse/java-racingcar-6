package racingcar.view;

import java.util.ArrayList;
import java.util.Map;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVING_MARK = "-";
    private static final String ANNOUNCEMENT_OF_WINNER = "최종 우승자 : %s";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESULT_LOG = "%s : %s \n";

    public void showResultLog() {
        System.out.print(NEW_LINE);
        System.out.println(RESULT_MESSAGE);
    }

    public void showOneRound(Map<String, Integer> gameResult) {
        for(String name : gameResult.keySet()) {
            Integer result = gameResult.get(name);
            System.out.printf(RESULT_LOG, name, MOVING_MARK.repeat(result));
        }
        System.out.print(NEW_LINE);
    }

    public void showWinners(ArrayList<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf(ANNOUNCEMENT_OF_WINNER, result);
    }
}
