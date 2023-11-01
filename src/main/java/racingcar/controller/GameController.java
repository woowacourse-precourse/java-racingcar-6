package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;

    private GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    private static class LazyHolder {
        public static final GameController instance = new GameController();
    }

    public static GameController getInstance() {
        return LazyHolder.instance;
    }

    public void newGame() {
        outputView.gameStart();
        List<String> carList = inputView.carListInput();
        outputView.roundInputMessage();
        int numOfRound = inputView.numOfRoundInput();
        outputView.ResultMessage();

        RacingGame racingGame = new RacingGame(carList, numOfRound);
        racingGame.carInputListToCarDTO();
        racingGame.CarDTO_TO_CarList();

        for (int i = 0; i < numOfRound; i++) {
            String result = racingGame.playRound();
            outputView.RoundResult(result);
        }

        String winnerList = racingGame.makeWinnerList();
        outputView.gameResult(winnerList);
    }
}
