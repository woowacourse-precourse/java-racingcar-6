package racingcar.model;

import java.util.ArrayList;
import java.util.List;


public class CarList {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> makeCarList(List<String> carNames, int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
        return cars;
    }
}
