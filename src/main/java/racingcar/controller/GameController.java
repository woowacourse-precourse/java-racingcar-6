package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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
        List<Car> cars = inputView.inputCarNames();

        outputView.askHowManyTimesToMove();
        int tryCounts = inputView.inputTryCount();
        outputView.printResultMessage();

        progressOneRound(cars, tryCounts);

        List<String> winners = gameService.findWinner(cars);

        outputView.printWinner(winners);
    }

    private void progressOneRound(List<Car> cars, int tryCounts) {

        for (int i = 0; i < tryCounts; i++) {
            gameService.moveCars(cars);
            outputView.printResult(cars);
        }
    }
}
