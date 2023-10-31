package racingcar.controller;

import racingcar.model.Circuit;
import racingcar.model.Round;
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

        Round round = inputView.readRound();
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < round.round(); i++) {
            roundResult.append(circuit.race());
        }
        outputView.printRoundResult(roundResult.toString());

        end();
    }

    private void end() {
        outputView.printResult(circuit.report());
    }
}
