package racingcar;

import java.util.List;
import racingcar.view.Output;

public class Game {
    GameManager gameManager = new GameManager();

    public void startGame() {
        List<Car> carList = gameManager.carSetting();
        int totalTryCount = gameManager.tryCountSetting();

        gamingWithTryCount(carList, totalTryCount);
        Output.printGameWinnerMessage(String.join(", ", gameManager.checkWinner(carList)));
    }

    private void gamingWithTryCount(List<Car> carList, int totalTryCount) {
        Output.printResultMessage();

        for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
            runGameForCar(carList);
            Output.printGameProgress(carList);
        }
    }

    private void runGameForCar(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
    }
}
