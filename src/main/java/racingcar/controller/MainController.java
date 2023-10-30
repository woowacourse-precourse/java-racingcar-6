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

    public void start() {
        circuit = new Circuit(inputView.readEntryNames());

        int round = inputView.readRound();
        String roundResult = "";
        for (int i = 0; i < round; i++) {
            roundResult += circuit.race();
        }
        outputView.printRoundResult(roundResult);
    }
}
