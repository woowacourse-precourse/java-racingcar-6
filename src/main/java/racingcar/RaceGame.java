package racingcar;

import java.util.Map;
import racingcar.controller.InputController;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;
import racingcar.view.OutputView;

public class RaceGame {
    private InputController inputController;
    private OutputView outputView;
    private Car car;

    public RaceGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        car = new Car();
        InputService inputService = new InputService();
        inputController = new InputController(inputService, car);

        outputView.requestCarName();
        receiveCarName();
        outputView.requestNumberOfAttempts();
        receiverNumberOfAttempts();

    }

    public void receiveCarName() {
        Map<String, Integer> carNameMap = this.inputController.receiveCarName();
        this.car.setName(carNameMap);
    }

    public void receiverNumberOfAttempts() {
        int numberOfAttempts = this.inputController.receiverNumberOfAttempts();
        this.car.setAttemptNumber(numberOfAttempts);
    }
}
