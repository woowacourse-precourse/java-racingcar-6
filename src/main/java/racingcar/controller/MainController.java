package racingcar.controller;

import racingcar.model.Circuit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private Circuit circuit;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void init() {
        circuit = new Circuit(inputView.readEntryNames());
    }

    public void start() {
        init();

        String roundResult = circuit.race(inputView.readRound());
        outputView.printRoundResult(roundResult);

        end();
    }

    private void end() {
        outputView.printResult(circuit.report());
    }
}
