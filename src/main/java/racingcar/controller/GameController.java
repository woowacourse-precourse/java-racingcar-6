package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRaceModel;
import racingcar.model.Validator;
import racingcar.view.GamePlayView;

public class GameController {

    CarRaceModel carRaceModel = new CarRaceModel();
    GamePlayView gamePlayView = new GamePlayView();
    Validator validator = new Validator();

    public void gameStart() {

        String carNames = gamePlayView.inputCarName();
        List<String> carNameList = carRaceModel.generateCarName(carNames);
        validator.validateCarName(carNameList);

        List<Car> carList = carRaceModel.generateCar(carNameList);

        int attempts = gamePlayView.inputAttemptsCount();
        validator.validateAttemptInput(attempts);

        gamePlayView.showGameResult(carList, attempts);

        List<String> winnerList = carRaceModel.findWinner(carList);

        gamePlayView.showGameWinner(winnerList);
    }
}
