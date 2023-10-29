package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingCar {

    private final List<Car> cars;
    private final Integer numberOfRetry;

    public RacingCar(List<Car> cars, Integer numberOfRetry) {
        this.cars = cars;
        this.numberOfRetry = numberOfRetry;
    }

    private void moveRandomAllCar() {
        cars.forEach(car -> car.moveForward(createRandomNumber()));
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
