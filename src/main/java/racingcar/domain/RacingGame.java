package racingcar.domain;

import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {
    private List<Car> cars;
    private int gameCount;
    private int currentGameCount;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public RacingGame(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
        this.currentGameCount = 0;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCurrentGameCount() {
        return currentGameCount;
    }

    public void addCurrentGameCount() {
        this.currentGameCount += 1;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void decideCarProgress(Car car) {
        int randomNum = randomNumberGenerator.createRandomNumber();
        if (randomNum > 3) {
            car.moveForward();
        }
    }
}
