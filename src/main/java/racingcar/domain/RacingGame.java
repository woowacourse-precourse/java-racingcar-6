package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int tryCount;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingGame(List<RacingCar> racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printResult();
        for (int i = 0; i < tryCount; i++) {
            moveRacingCars();
            outputView.printAllRacingCarsPosition(racingCars);
        }
        outputView.printWinners(findWinners());
    }

    private void moveRacingCars() {
        for (RacingCar car : racingCars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
    }

    private List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();

        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar);
            }
        }

        return winners;
    }

    private int findMaxPosition() {
        int max = 0;

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > max) {
                max = racingCar.getPosition();
            }
        }

        return max;
    }
}
