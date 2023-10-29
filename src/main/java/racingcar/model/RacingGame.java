package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> racingCars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(List<String> carNames, int totalRounds) {
        this.racingCars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void moveCars() {
        for (RacingCar racingCar : racingCars) {
            moveCar(racingCar);
        }
    }

    public void moveCar(RacingCar racingCar) {
        int number = randomNumberGenerator.generate();
        if (number >= 4) {
            racingCar.moveForward();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}
