package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.Input;
import racingcar.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private Game game;

    public RacingGame() {
    }

    public void startGame() {
        ready();
        game.start();
        game.printWinners();
    }

    public void ready() {
        Output.carNameInputMessage();
        String carNames = Input.carNamesInput();
        Output.attemptInputMessage();
        int numberOfAttempts = Input.attemptInput();
        game = new Game(carNames, numberOfAttempts);
    }

    public static void exception(String str) {
        Console.close();
        throw new IllegalArgumentException(str);
    }
}
