package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }
}
