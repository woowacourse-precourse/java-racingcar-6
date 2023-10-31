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

    public RaceGame(OutputView outputView, Car car, InputController inputController) {
        this.outputView = outputView;
        this.car = car;
        this.inputController = inputController;
    }

    public void start() {
        outputView.requestCarName();
        receiveCarName();

        outputView.requestNumberOfAttempts();
        receiverNumberOfAttempts();

        outputView.printStartCarRace();
        doRace();

        String winner = inputController.choiceWinner(car);
        outputView.printWinner(winner);
    }

    public void receiveCarName() {
        Map<String, Integer> carNameMap = this.inputController.receiveCarName();
        this.car.setName(carNameMap);
    }

    public void receiverNumberOfAttempts() {
        int numberOfAttempts = this.inputController.receiverNumberOfAttempts();
        this.car.setAttemptNumber(numberOfAttempts);
    }

    public void doRace() {
        for (int i = 0; i < car.getAttemptNumber(); i++) {
            inputController.doRace(car);
            outputView.printCar(car);
        }
    }
}
