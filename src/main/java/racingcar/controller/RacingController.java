package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingCircuit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCircuit circuit;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.circuit = new RacingCircuit();
    }

    public void run() {
        List<Car> cars = inputView.getCars();
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            circuit.race(cars);
        }
    }
}
