package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(Constants.MIN_RANDOM_RANGE, Constants.MAX_RANDOM_RANGE)));
    }

    public List<Car> getCars() {
        return cars;
    }
}
