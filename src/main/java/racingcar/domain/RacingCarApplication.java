package racingcar.domain;

import racingcar.dto.CarDTO;
import racingcar.presentation.CarViewer;

import java.util.List;

public class RacingCarApplication {
    private final CarViewer carViewer;

    public RacingCarApplication(CarViewer carViewer) {
        this.carViewer = carViewer;
    }

    public void run() {

        List<CarName> carNames = carViewer.inputCarNames();
        Cars cars = Cars.createByNames(carNames);

        CarGameRound gameRound = carViewer.inputGameRound();

        CarGame carGame = CarGame.create(cars, gameRound);
        CarDTO.ProgressResult progressResult = carGame.race();

        carViewer.outputExecute();
        carViewer.outputResult(progressResult);

        CarDTO.WinnerNames winnerNames = carGame.getWinner();

        carViewer.outputWinner(winnerNames);
    }
}
