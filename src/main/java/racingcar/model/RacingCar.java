package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingCar {

    private final List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void moveRandomAllCar() {
        cars.forEach(car -> car.moveForward(createRandomNumber()));
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
