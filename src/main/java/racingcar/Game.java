package racingcar;

import java.util.List;

public class Game {
    private final Cars cars;
    private final TrialNumber trialNumber;

    public Game(List<String> carNames, int trialNumber) {
        this.cars = initCars(carNames);
        this.trialNumber = initTrialNumber(trialNumber);
    }

    private Cars initCars(List<String> carNames) {
        List<Car> carsWithName = createCarsWithName(carNames);
        return new Cars(carsWithName);
    }

    private List<Car> createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private TrialNumber initTrialNumber(int trialNumber) {
        return new TrialNumber(trialNumber);
    }
}