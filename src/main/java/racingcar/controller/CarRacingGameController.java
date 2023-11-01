package racingcar.controller;

import java.util.Objects;
import racingcar.enums.Message;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    private CarRacingGameController(InputView inputView, OutputView outputView) {
        Objects.requireNonNull(inputView);
        Objects.requireNonNull(outputView);
        this.inputView = inputView;
        this.outputView = outputView;
        postConstruct();
    }

    public static CarRacingGameController of(InputView inputView, OutputView outputView) {
        Objects.requireNonNull(inputView);
        Objects.requireNonNull(outputView);
        return new CarRacingGameController(inputView, outputView);
    }

    private void postConstruct() {
        racingGame = RacingGame.of(inputView.getInputCarNames(), inputView.getInputTrialCount());
    }

    public void playGame() {
        printRunResult();
        printFinalWinner();
        inputView.close();
    }

    private void printRunResult() {
        outputView.printRunResult(Message.RUN_RESULT.getMessage());
        repeatRound();
    }

    private void repeatRound() {
        while (racingGame.isNotFinished()) {
            racingGame.increaseCurrentRound();
            racingGame.runRound();
            outputView.printRoundResult(racingGame.getRunResultMessage());
        }
        racingGame.decideWinners();
    }

    private void printFinalWinner() {
        outputView.printFinalWinner(racingGame.getFinalWinnerMessage());
    }
}
