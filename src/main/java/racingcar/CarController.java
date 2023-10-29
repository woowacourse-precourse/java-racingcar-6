package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final List<Car> cars;

    public CarController(String carNames) {
        this.cars = toList(carNames);
    }

    private List<Car> toList(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] name = carNames.split(",");
        for (String s : name) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

}
