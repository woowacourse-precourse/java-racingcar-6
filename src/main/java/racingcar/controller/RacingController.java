package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGarage;
import racingcar.domain.TryCount;
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
        CarGarage carGarage = inputView.getCars();
        TryCount count = inputView.getTryCount();
        outputView.printResultMessage();
        for (int i = 0; i < count.value(); i++) {
            circuit.race(carGarage);
            outputView.printRaceResult(carGarage);
        }
        List<Car> winner = carGarage.findWinner();
        outputView.printWinner(winner);
    }
}
