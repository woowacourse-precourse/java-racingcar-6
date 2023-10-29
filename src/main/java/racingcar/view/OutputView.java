package racingcar.view;

import java.util.Map;

public class OutputView {
    private static final String RESULT_LOG = "실행 결과";
    private static final String MOVING_MARK = "-";

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
}
