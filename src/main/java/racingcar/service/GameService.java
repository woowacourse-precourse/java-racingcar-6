package racingcar.service;

import java.util.List;
import racingcar.utils.GameUtils;
import racingcar.model.Car;

public class GameService {
    GameUtils gameUtils = new GameUtils();

    public void start() {
        this.runGame();
    }

    private void runGame() {
        List<Car> cars = gameUtils.convertCarList(gameUtils.setCarList());
        int trial = gameUtils.setTrialNumber();
        gameUtils.processGame(cars, trial);
    }
}