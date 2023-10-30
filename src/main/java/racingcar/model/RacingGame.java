package racingcar.model;

import static racingcar.exception.RacingCarExceptionType.*;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final List<RacingCar> racingCars;

    public RacingGame(CarNames carNames) {
        this.racingCars = carNames.getNames().stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        racingCars.forEach(this::moveCar);
    }

    private void moveCar(RacingCar racingCar) {
        int number = randomNumberGenerator.generate();
        if (number >= MOVE_THRESHOLD) {
            racingCar.moveForward();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getWinners() {
        int maxPosition = findMaxCarPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxCarPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_CAR_LIST.getMessage()));
    }

}
