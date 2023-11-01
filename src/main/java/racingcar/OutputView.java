package racingcar;

import static racingcar.constant.Constants.GAME_RESULT;
import static racingcar.constant.Constants.INPUT_NAMES;
import static racingcar.constant.Constants.INPUT_TIMES;
import static racingcar.constant.Constants.RACE_WINNERS;

public class OutputView {

    private void print(final String message) {
        System.out.print(message);
    }

    private void println(final String message) {
        System.out.println(message);
    }

    public void naming() {
        println(INPUT_NAMES);
    }

    public void counting() {
        println(INPUT_TIMES);
    }

    public void execution() {
        println(GAME_RESULT);
    }

    public void raceOver() {
        print(RACE_WINNERS);
    }

    public void winnerResult(String winners) {
        raceOver();
        println(winners);

    }
}
