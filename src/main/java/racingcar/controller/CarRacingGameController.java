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

    private void postConstruct() {
        racingGame = RacingGame.of(inputView.getInputCarNames(), inputView.getInputTrialCount());
    }

    public static CarRacingGameController of(InputView inputView, OutputView outputView) {
        Objects.requireNonNull(inputView);
        Objects.requireNonNull(outputView);
        return new CarRacingGameController(inputView, outputView);
    }

    public void playGame() {
        outputView.printRunResult(Message.RUN_RESULT.getMessage());
        repeatRounds();
        outputView.printFinalWinner(racingGame.getWinnerMessage());
        inputView.close();
    }

    private void repeatRounds() {
        while (racingGame.isNotFinished()) {
            racingGame.increaseCurrentRound();
            racingGame.runRound();
            outputView.printRoundResult(racingGame.getRunResultMessage());
        }
        racingGame.decideWinner();
    }
}
