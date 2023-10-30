package racingcarv2.model;

import java.util.ArrayList;
import java.util.List;
import racingcarv2.model.Car;
import racingcarv2.util.RandomGenerator;

public class RacingCars {
    public static final int END_INCLUSIVE = 9;
    public static final int START_INCLUSIVE = 0;
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }

    public List<Car> moveAllCars() {
        for (Car racingCar : racingCars) {
            racingCar.move(RandomGenerator.generateRandomNumber(START_INCLUSIVE, END_INCLUSIVE));
        }
        return racingCars;
    }
}
