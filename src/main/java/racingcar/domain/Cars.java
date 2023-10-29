package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = mapCarNamesToCars(carNames);
        return cars;
    }

    private List<Car> mapCarNamesToCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = createCar(carName);
            cars.add(car);
        }
        return cars;
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }
}
