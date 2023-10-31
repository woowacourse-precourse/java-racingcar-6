package racingcar.controller;

import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    private RacingModel racingModel;

    private int roundCount;

    public void start() {
        setUp();
        play();
        showWinner();
    }

    public void setUp() {
        InputController inputController = new InputController();
        racingModel = new RacingModel(inputController.setCarNames(InputView.inputCarNames()));
        roundCount = inputController.setRoundCount(InputView.inputRoundCount());
    }

    public void play() {
        OutputView.printRoundResultMessage();
        IntStream.range(0, roundCount).forEach(i -> OutputView.printRoundResult(racingModel.playRound()));
    }

    public void showWinner() {
        OutputView.printWinner(racingModel.getWinner());
    }


}
