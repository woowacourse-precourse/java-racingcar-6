package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.vo.Attempt;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private InputView inputView;
    private OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // input car name
        String carNames = inputView.inputCarNames();
        hasComma(carNames);
        RacingGame game = RacingGame.from(carNames);

        // input attempt
        Attempt attempt = Attempt.from(inputView.inputAttempts());

        // start game
        outputView.printResultMessage();
        String result = game.playGame(attempt);
        outputView.printGameResult(result);

        // print winner
        String winner = determineWinner(game);
        outputView.printGameWinner(winner);
    }

    private void hasComma(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("사용자는 최대 2명 이상입니다.");
        }
    }

    public String determineWinner(RacingGame game) {
        // determine winner
        return game.determineWinner();
    }
}
