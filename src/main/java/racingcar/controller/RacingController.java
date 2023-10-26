package racingcar.controller;

import racingcar.domain.CarGarage;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.service.RacingCircuit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

        raceCar(count, carGarage);

        Winner winner = carGarage.findWinner();
        outputView.printWinner(winner);
    }

    private void raceCar(TryCount count, CarGarage carGarage) {
        outputView.printResultMessage();
        for (int i = 0; i < count.value(); i++) {
            circuit.race(carGarage);
            outputView.printRaceResult(carGarage);
        }
    }
}
