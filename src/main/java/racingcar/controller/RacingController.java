package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private static RacingGame game;
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run(){
        startGame();
        playGame();
        endGame();
    }

    private static void startGame() {
        List<String> names = input.readCarNames();
        int tryCount = input.readTryCount();

        Cars cars = new Cars(names);
        game = new RacingGame(cars, tryCount);
    }

    private static void playGame() {
        String gameStatus = game.makeStatus();
        output.printResultTitle();
        output.printResult(gameStatus);
    }

    private static void endGame(){

    }




}
