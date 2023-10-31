package racingcar;

import racingcar.controller.InputController;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Car car = new Car();
        InputService inputService = new InputService();
        InputController inputController = new InputController(inputService);
        RaceGame game = new RaceGame(outputView, car, inputController);

        game.start();
    }
}
