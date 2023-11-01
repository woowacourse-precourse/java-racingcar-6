package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.car.Car;

public class Race {
    private static final int RANDOM_NUMBER_LOWER_BOUND = 0;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 9;

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
