package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomUtil;

public class RacingGame {
    private RandomUtil randomUtil;
    private Cars cars;
    private GameStatus gameStatus;

    public RacingGame(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public void generateCars(String carNames) {
        cars = new Cars(randomUtil, carNames);
    }

    public void startRacingGame(int executionCnt) {
        gameStatus = new GameStatus(executionCnt);
    }

    public boolean isRunning() {
        return gameStatus.isRunning();
    }

    public void runRace() {
        cars.runRace();
    }

    public Cars getCars() {
        return cars;
    }

}
