package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> racingCars;

    private Cars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static Cars createCars(List<String> stringCars) {
        List<Car> racingCars = new ArrayList<>();
        for (String stringCar : stringCars) {
            Car car = Car.makeCar(stringCar);
            racingCars.add(car);
        }
        return new Cars(racingCars);
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
