package racingcar.controller;

import java.util.List;
import racingcar.model.Game;
import racingcar.view.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarGameController(){
        this.outputView = new OutputView();
        InputParser inputParser = new InputParser();
        this.inputView = new InputView(inputParser);
    }

    public void runWholeGame() {
        Game game = init();
        playGame(game);
        afterGame(game);
    }

    private void playGame(Game game) {
        outputView.displayExecutionResultsStartView();
        while (game.isPlayable()) {
            game.oneRace();
            outputView.displayExecutionResultsView(game.getCurrentCarPositions());
        }
    }

    private void afterGame(Game game) {
        outputView.displayWinnerView(game.getWinners());
    }

    private Game init() {
        List<String> inputCars = inputView.getInputCarsView();
        int inputCount = inputView.getInputTryView();
        return new Game(inputCars, inputCount);
    }

}
