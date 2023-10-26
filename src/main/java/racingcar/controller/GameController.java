package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.service.Referee;
import racingcar.view.OutputView;

public class GameController {

    private final InputController inputController;

    private final GameService gameService;

    private final Referee referee;

    private final OutputView outputView;

    public GameController() {
        inputController = new InputController();
        gameService = new GameService();
        referee = new Referee();
        outputView = new OutputView();
    }

    public void play() {
        int trialNumber = inputController.getTrialNumber();
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList, inputController.inputCarNames());
        outputView.showResultMessage();

        playUntilTrialNumber(trialNumber, cars);
        outputView.showWinner(referee, cars);
    }

    private void playUntilTrialNumber(int trialNumber, Cars cars) {
        for (int i = 0; i < trialNumber; i++) {
            gameService.playOnce(cars);
            outputView.showResult(cars.getCars());
        }
    }
}
