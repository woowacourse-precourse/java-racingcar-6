package racingcar;

import java.util.List;
import racingcar.view.Output;

public class Game {
    GameManager gameManager = new GameManager();

    public void startGame() {
        List<Car> carList = gameManager.carSetting();
        int totalTryCount = gameManager.tryCountSetting();

        runGame(carList, totalTryCount);

        Output.printGameWinnerMessage(String.join(", ", gameManager.checkWinner(carList)));
    }

    private void runGame(List<Car> carList, int totalTryCount) {
        Output.printResultMessage();

        for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
            carList.forEach(Car::move);
            Output.printGameProgress(carList);
        }
    }
}
