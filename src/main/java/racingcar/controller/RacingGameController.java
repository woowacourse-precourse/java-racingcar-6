package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RacingGameController {
    public void play() {
        String[] carNames = InputView.inputCarNames();
        int rounds = InputView.inputRaceRounds();

        RacingGame racingGame = new RacingGame(carNames, rounds);

        for (int i = 0; i < racingGame.getRounds(); i++) {
            OutputView.printRound(racingGame.playRound());
        }

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
