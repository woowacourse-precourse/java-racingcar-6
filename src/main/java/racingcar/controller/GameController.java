package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(final InputView inputView, final OutputView outputView, final GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        Cars cars = makeCars();
    }

    private Cars makeCars() {
        outputView.printNamesGuide();
        String carNames = inputView.readCarNames();
        return gameService.createCars(carNames);
    }

}
