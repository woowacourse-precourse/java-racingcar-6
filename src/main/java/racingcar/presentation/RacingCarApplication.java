package racingcar.presentation;

import racingcar.domain.CarGame;
import racingcar.domain.CarGameRound;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.util.MovableSymbolNumberGenerator;
import racingcar.util.NumberGenerator;

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

        NumberGenerator numberGenerator = new MovableSymbolNumberGenerator();
        CarGame carGame = CarGame.create(cars, gameRound);
        CarDTO.ProgressResult progressResult = carGame.race(numberGenerator);

        carViewer.outputExecute();
        carViewer.outputResult(progressResult);

        CarDTO.WinnerNames winnerNames = carGame.getWinner();

        carViewer.outputWinner(winnerNames);
    }
}
