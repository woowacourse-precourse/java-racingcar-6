package racingcar.controller;

import racingcar.domain.dto.RacingCarProgressDTO;
import racingcar.domain.dto.RacingCarWinnerDTO;
import racingcar.domain.model.AttemptsNumber;
import racingcar.domain.model.Cars;
import racingcar.domain.service.RacingCarRandomGenerator;
import racingcar.domain.service.RacingGame;
import racingcar.domain.service.RacingGameFactory;
import racingcar.domain.service.RandomMoveJudge;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGameFactory racingGameFactory;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.racingGameFactory = new RacingGameFactory(new RandomMoveJudge(new RacingCarRandomGenerator()));
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        RacingGame racingGame = getRacingGame();
        AttemptsNumber attemptsNumber = getAttemptsNumber();
        startRacingGame(racingGame, attemptsNumber);
    }

    private void startRacingGame(RacingGame racingGame, AttemptsNumber attemptsNumber) {
        outputView.outputResultHeader();
        for (int i = 0; i < attemptsNumber.attempts(); i++) {
            racingGame.advance();
            RacingCarProgressDTO progress = racingGame.getProgressStatus();
            outputView.printProgress(progress);
        }
        RacingCarWinnerDTO winner = racingGame.determineWinner();
        outputView.printWinner(winner);
    }

    private AttemptsNumber getAttemptsNumber() {
        outputView.printForNumberOfAttempts();
        return inputView.readAttemptsNumber();
    }

    private RacingGame getRacingGame() {
        outputView.printWelcomeMessage();
        Cars cars = inputView.readCarNames();
        return racingGameFactory.createRacingGame(cars);
    }
}
