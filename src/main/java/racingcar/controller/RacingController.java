package racingcar.controller;

import java.util.List;
import racingcar.JudgeWinnerImpl;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static RacingGame game;
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        playGame();
        endGame();
    }

    private static void playGame() {
        List<String> names = input.readCarNames();
        int tryCount = input.readTryCount();

        game = new RacingGame(new Cars(names), new JudgeWinnerImpl());

        output.printResultTitle();

        for(int i=0; i<tryCount; i++){
            game.moveOneStep();
            output.printStatus(game.getStatus());
        }

    }



    private static void endGame() {

    }


}
