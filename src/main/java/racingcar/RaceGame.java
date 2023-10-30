package racingcar;

import java.util.Map;
import racingcar.controller.InputController;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;
import racingcar.view.OutputView;

public class RaceGame {
    private InputController inputController;
    private OutputView outputView;
    private InputService inputValidateService;

    public RaceGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        Car car = new Car();
        InputService inputService = new InputService();
        InputController inputController = new InputController(inputService, car);

        outputView.requestCarName();
        Map<String, Integer> carNameMap = inputController.receiveCarName();
        car.setName(carNameMap);
    }
}
