package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.model.CarRaceModel;
import racingcar.model.CarTextModel;
import racingcar.model.Validator;
import racingcar.view.GamePlayView;

public class GameController {

    CarRaceModel carRaceModel = new CarRaceModel();
    CarTextModel carTextModel = new CarTextModel();
    GamePlayView gamePlayView = new GamePlayView();
    Validator validator = new Validator();

    public void gameStart() {

        String carNames = gamePlayView.inputCarName();
        HashMap<String, String> carList = carTextModel.parseCarNames(carNames);
        validator.validateCarName(carList);

        int attempts = gamePlayView.inputAttemptsCount();
        validator.validateAttemptInput(attempts);

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<attempts; i++) {
            carList = carRaceModel.saveCarMovement(carList);
            gamePlayView.showTurnResult(carList);
            System.out.println();
        }

        List<String> winnerList = carRaceModel.findWinner(carList);

        gamePlayView.showGameWinner(winnerList);
    }

}
