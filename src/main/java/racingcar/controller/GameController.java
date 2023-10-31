package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.vo.Attempt;
import racingcar.view.InputView;

public class GameController {

    private RacingGameController racingGameController;
    private InputView inputView;

    public GameController(RacingGameController racingGameController,
            InputView inputView) {
        this.racingGameController = racingGameController;
        this.inputView = inputView;
    }

    public void run() {
        // input car name event
        String carNames = inputView.inputCarNames();
        List<Car> cars = racingGameController.makeCar(carNames);

        // input attempt event
        String attempts = inputView.inputAttempts();
        Attempt attempt = racingGameController.setAttempts(attempts);

        // start event
        for (int i = 0; i < attempt.getCount(); i++) {
            String result = racingGameController.startGame(cars);
        }

    }
}
