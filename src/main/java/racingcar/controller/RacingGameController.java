package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.manager.Validator;

public class RacingGameController {
    public void play() {
        String[] carNames = InputView.inputCarNames();
        String roundsInput = InputView.inputRaceRounds();

        int rounds = Validator.validateRaceRoundInput(roundsInput);

        RacingGame racingGame = new RacingGame(carNames, rounds);

        for (int i = 0; i < racingGame.getRounds(); i++) {
            OutputView.printRound(racingGame.playRound());
        }

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
