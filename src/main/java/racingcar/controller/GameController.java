package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.GameModel;
import racingcar.model.Validator;
import racingcar.view.GamePlayView;

public class GameController {

    GameModel gameModel = new GameModel();
    GamePlayView gamePlayView = new GamePlayView();
    Validator validator = new Validator();

    public void start() {

        String carNames = gamePlayView.inputCarName();
        List<String> carNameList = gameModel.generateCarName(carNames);
        validator.validateCarName(carNameList);
        validator.isCarNameUnique(carNameList);

        List<Car> carList = gameModel.generateCar(carNameList);

        int attempts = gamePlayView.inputAttemptsCount();
        validator.validateAttemptInput(attempts);

        gamePlayView.showResult(carList, attempts);

        List<String> winnerList = gameModel.findWinner(carList);

        gamePlayView.showWinner(winnerList);
    }
}
