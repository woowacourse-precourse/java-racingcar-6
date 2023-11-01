package racingcar.Domain;

import static racingcar.common.GameMessage.EXECUTION_RESULTS_MESSAGE;
import static racingcar.common.RacingCarConstant.MAX_RANGE;
import static racingcar.common.RacingCarConstant.MIN_RANGE;
import static racingcar.common.RacingCarConstant.SPEED_LOWER_LIMIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    private final List<Car> cars;

    private final static String COLON = " : ";
    private final static String DASH = "-";

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    private int carSpeed() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    private boolean checkFastEnough() {
        return carSpeed() >= SPEED_LOWER_LIMIT;
    }

    private void racingResult() {
        for (Car car : this.cars) {
            if (checkFastEnough()) {
                car.moveForward();
            }
        }
    }

    private void printResult() {
        for (Car car : this.cars) {
            System.out.print(car.getName() + COLON);

            for (int i = 0; i < car.getMovingDistance(); i++) {
                System.out.print(DASH);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void result(int attemptsNumber) {
        System.out.print(EXECUTION_RESULTS_MESSAGE);

        for (int i = 0; i < attemptsNumber; i++) {
            racingResult();
            printResult();
        }
    }
}
