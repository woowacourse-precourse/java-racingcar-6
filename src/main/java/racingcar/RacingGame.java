package racingcar;

import static racingcar.Constant.MIN_ATTEMPT_COUNT;
import static racingcar.Constant.PRINT_RESULT_MESSAGE;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int attemptCount;

    public RacingGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void gameStart() {
        System.out.print(PRINT_RESULT_MESSAGE);
        while (attemptCount-- >= MIN_ATTEMPT_COUNT) {
            moveCars();
            printResult();
        }
        printWinner();
    }

    private void moveCars() {

    }

    private void printResult() {

    }

    private void printWinner() {

    }
}