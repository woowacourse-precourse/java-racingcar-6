package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.domain.TryCount;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(GameService gameService, InputView inputView, OutputView outputView) {

        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        outputView.printStartGameMessage();
        Cars cars = inputView.inputCarNames();

        outputView.askHowManyTimesToMove();
        TryCount tryCounts = inputView.inputTryCount();
        outputView.printResultMessage();

        progressRounds(cars, tryCounts);

        Winners winners = cars.findWinners();

        outputView.printWinner(winners);
    }

    private void progressRounds(Cars cars, TryCount tryCounts) {

        for (int i = 0; i < tryCounts.value(); i++) {
            gameService.moveCars(cars);
            outputView.printResult(cars);
        }
    }
}
