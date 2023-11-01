package racingcar.Controller;

import racingcar.Domain.CarGroup;
import racingcar.Factory.Factory;
import racingcar.Model.CarModel;
import racingcar.Model.CarModelImpl;
import racingcar.Model.GameModel;
import racingcar.Model.GameModelImpl;
import racingcar.Model.RoundModel;
import racingcar.Model.RoundModelImpl;
import racingcar.View.InputView;
import racingcar.View.OutPutView;

public class GameController {

    private InputView inputView;
    private OutPutView outPutView;
    private CarModel carModel;
    private RoundModel roundModel;
    private GameModel gameModel;

    public void initGame() {
        Factory factory = new Factory();

        inputView = factory.getInputView();
        outPutView = factory.getOutPutView();
        carModel = factory.getCarModel();
        roundModel = factory.getRoundModel();
        gameModel = factory.getGameModel();

        startGame();
    }

    public void startGame() {
        String carNamesInput = inputView.getCarName();
        CarGroup carGroup = carModel.preProcessing(carNamesInput);
        String numberOfRoundsInput = inputView.getNumberOfRound();
        Integer numberOfRounds = roundModel.preProcessing(numberOfRoundsInput);

        outPutView.showHeaderPrompt();
        while (numberOfRounds > 0) {
            carGroup = gameModel.playGameRound(carGroup);
            outPutView.showRoundResult(carGroup);
            numberOfRounds--;
        }

        outPutView.showFinalWinner(carGroup);
    }
}
