package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.utils.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    public Game beforeGameStart() {
        OutputView.outputCarNameMessage();
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars(carNames);

        OutputView.outputGameTryMessage();
        int gameTry = Convertor.convertStringIntoInteger(InputView.inputGameTry());
        Game game = new Game(cars, gameTry);

        System.out.println();

        return game;
    }

    public void gameStart() {
        OutputView.outputGameStartMessage();
    }

    public void gameProceed(Game game) {

        int gameTry = game.getGameTry();
        Cars cars = game.getCars();

        while (gameTry-- > 0) {
            cars.compete();
            OutputView.outputEachStage(cars);
        }
    }

    public void gameOver(Game game) {
        OutputView.outputGameResultMessage();
        OutputView.outputGameResult(game.getWinners());
    }

}
