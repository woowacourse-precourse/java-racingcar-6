package racingcar.controller;

import java.util.List;
import racingcar.controller.dto.ResponseDto;
import racingcar.model.Car;
import racingcar.model.vo.Attempt;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private RacingGameController racingGameController;
    private InputView inputView;
    private OutputView outputView;

    public GameController(RacingGameController racingGameController,
            InputView inputView,
            OutputView outputView) {
        this.racingGameController = racingGameController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // input car name event
        String carNames = inputView.inputCarNames();
        List<Car> cars = racingGameController.makeCar(carNames);

        // input attempt event
        String attempts = inputView.inputAttempts();
        Attempt attempt = racingGameController.setAttempts(attempts);

        // start event
        outputView.printResultMessage();
        for (int i = 0; i < attempt.getCount(); i++) {
            ResponseDto responseDto = racingGameController.startGame(cars);
            outputView.printOneGame(responseDto);
        }
    }
}
