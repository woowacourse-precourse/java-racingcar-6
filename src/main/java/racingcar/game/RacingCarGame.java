package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.utils.randomGenerator.RandomNumberGenerator;

public class RacingCarGame {

    private List<Car> cars;


    public RacingCarGame(RandomNumberGenerator randomNumberGenerator, Writer writer) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.writer = writer;
    }

    public void play(List<String> carNames, int attemptCount) {
        initCars(carNames);
        display(EXECUTION_RESULT);
        executeRounds(attemptCount);
        display(resultGenerator.makeWinnersResult(getWinners()));
    }

    private void executeRounds(int attemptCount) {
        for (int round = MIN_DISTANCE; round < attemptCount; round++) {
            moveCarsForward();
        }
    }

    private void moveCarsForward() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomSingleDigit();
            if (randomNumber >= FORWARD_CONDITIONAL_VALUE) {
                car.move();
            }
        }
    }

    private void initCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

}
