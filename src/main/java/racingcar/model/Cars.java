package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> moveAll() {
        for (Car car : cars) {
            int randomNumber = car.createRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
        return cars;
    }


}
