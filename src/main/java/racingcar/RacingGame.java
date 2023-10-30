package racingcar;

import static racingcar.Constant.DISTANCE;
import static racingcar.Constant.MAX_RANDOM_NUM;
import static racingcar.Constant.MIN_ATTEMPT_COUNT;
import static racingcar.Constant.MIN_RANDOM_NUM;
import static racingcar.Constant.MOVE_FORWARD_NUM;
import static racingcar.Constant.PRINT_DISTANCE_SEPARATOR;
import static racingcar.Constant.PRINT_RESULT_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
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
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
            if (randomNum >= MOVE_FORWARD_NUM) {
                car.moveForward();
            }
        }
    }

    private void printResult() {
        cars.forEach(car -> {
            System.out.print(car.getName() + PRINT_DISTANCE_SEPARATOR);
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print(DISTANCE);
            }
            System.out.println();
        });
        System.out.println();
    }

    private void printWinner() {

    }
}