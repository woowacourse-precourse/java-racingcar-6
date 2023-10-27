package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    @Override
    public String toString() {
        return "CarRepository{" +
                "carRepository=" + cars +
                '}';
    }
}
