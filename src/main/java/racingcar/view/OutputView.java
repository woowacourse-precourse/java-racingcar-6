package racingcar.view;

import static racingcar.common.Constants.ANNOUNCEMENT_OF_WINNER;
import static racingcar.common.Constants.MOVING_MARK;
import static racingcar.common.Constants.NEW_LINE;
import static racingcar.common.Constants.RESULT_LOG;
import static racingcar.common.Constants.RESULT_MESSAGE;

import java.util.ArrayList;
import java.util.Map;

public class OutputView {

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
