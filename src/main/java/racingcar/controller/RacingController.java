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
    private static int tryCount;

    public static void run() {
        startGame();
        playGame();
        endGame();
    }

    private static void startGame(){
        List<String> names = input.readCarNames();
        tryCount = input.readTryCount();
        game = new RacingGame(names, new JudgeWinnerImpl(), new RandomNumberGenerator());
    }

    private static void playGame() {
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
