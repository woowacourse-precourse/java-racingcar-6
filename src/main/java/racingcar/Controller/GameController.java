package racingcar.Controller;

import racingcar.Domain.CarGroup;
import racingcar.Model.CarModel;
import racingcar.Model.GameModel;
import racingcar.Model.RoundModel;
import racingcar.View.InputView;
import racingcar.View.OutPutView;

public class GameController {

    InputView inputView;
    OutPutView outPutView;
    CarModel carModel;
    RoundModel roundModel;
    GameModel gameModel;

    public void initGame() {
        inputView = new InputView();
        outPutView = new OutPutView();
        carModel = new CarModel();
        roundModel = new RoundModel();
        gameModel = new GameModel();

        startGame();
    }

    public void startGame() {
        String carNames = inputView.getCarName();
        CarGroup carGroup = carModel.preProcessing(carNames);
        String numberOfRound = inputView.getNumberOfRound();
        Integer round = roundModel.preProcessing(numberOfRound);

        outPutView.showPrompt();
        while (round > 0) {
            carGroup = gameModel.playGameRound(carGroup);
            outPutView.showRoundResult(carGroup);
            round--;
        }

        outPutView.showFinalWinner(carGroup);
    }
}
