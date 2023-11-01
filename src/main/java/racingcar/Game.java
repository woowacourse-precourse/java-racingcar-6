package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.view.Output;

public class Game {
    GameManager gameManager = new GameManager();

    public void startGame() {
        List<Car> carList = gameManager.carSetting();
        int totalTryCount = gameManager.tryCountSetting();

        runGameForTryCount(carList, totalTryCount);

        Output.printGameWinnerMessage(String.join(", ", gameManager.checkWinner(carList)));
    }

    private void runGameForTryCount(List<Car> carList, int totalTryCount) {
        Output.printResultMessage();

        IntStream.range(0, totalTryCount).forEach(tryCount -> {
            carList.forEach(Car::move);
            Output.printGameProgress(carList);
        });
    }
}
