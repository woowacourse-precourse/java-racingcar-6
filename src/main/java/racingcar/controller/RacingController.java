package racingcar.controller;

import java.util.List;
import racingcar.model.JudgeWinnerImpl;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static RacingGame game;

    public static void run() {
        playGame();
        endGame();
    }

    private static void playGame() {
        List<String> names = input.readCarNames();
        int tryCount = input.readTryCount();

        game = new RacingGame(names, new JudgeWinnerImpl(), new RandomNumberGenerator());

        output.printResultTitle();

        for (int i = 0; i < tryCount; i++) {
            game.move();
            output.printStatus(game.getStatus());
        }
    }

    private static void endGame() {
        List<String> winner = game.judge();
        output.printWinner(winner);
    }


}
