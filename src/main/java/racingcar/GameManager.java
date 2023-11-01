package racingcar;

import racingcar.car.Cars;

import java.util.List;

public class GameManager {

    private static GameManager gameManager;

    private GameManager() {}

    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public void startGame() {
        List<String> nameList = IOManager.getInstance().readCarNameList();
        Cars cars = new Cars(nameList);

        int tryCount = IOManager.getInstance().readTryCount();

        IOManager.getInstance().notifyStartRacing();
        for (int i = 0; i < tryCount; i++) {
            cars.tryOnce();
            IOManager.getInstance().printRacingResult(cars);
        }
        IOManager.getInstance().printWinners(cars);
    }
}
