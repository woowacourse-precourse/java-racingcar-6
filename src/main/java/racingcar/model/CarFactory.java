package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private final List<Car> cars;

    public CarFactory() {
        this.cars = new ArrayList<>();
    }

    public List<Car> generateCars(List<String> carNameList) {

        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
