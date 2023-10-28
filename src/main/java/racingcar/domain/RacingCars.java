package racingcar.domain;

import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars() {
    }

    public void setRacingCars(String[] carsName) {
        for (String carName : carsName) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }
}
