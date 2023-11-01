package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void setRacingCars(String[] carsName) {
        for (String carName : carsName) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
