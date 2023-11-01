package racingcarv2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcarv2.util.RandomGenerator;

public class RacingCars {
    private static final int END_INCLUSIVE = 9;
    private static final int START_INCLUSIVE = 0;
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

    public List<Name> findWinnerName() {
        return getNamesWithSamePosition(findMaxPositionCar());
    }

    private List<Name> getNamesWithSamePosition(Car maxPositionCar) {
        return racingCars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return racingCars.stream()
                .max(Car::compareTo)
                .get();
    }
}
