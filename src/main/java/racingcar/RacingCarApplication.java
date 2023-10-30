package racingcar;

import racingcar.presentation.CarViewer;

import java.util.List;
import java.util.Map;

public class RacingCarApplication {
    private final CarViewer carViewer;

    public RacingCarApplication(CarViewer carViewer) {
        this.carViewer = carViewer;
    }

    public void run() {

        List<String> carNames = carViewer.inputCarNames();
        Cars cars = Cars.createByNames(carNames);

        CarGameRound gameRound = carViewer.inputGameRound();

        CarGame carGame = CarGame.create(cars, gameRound);
        List<Map<String, Integer>> gameResult = carGame.race();

        carViewer.outputExecute();
        carViewer.outputResult(gameResult);

        carViewer.outputWinner(carGame.getWinnerNames());
    }
}
