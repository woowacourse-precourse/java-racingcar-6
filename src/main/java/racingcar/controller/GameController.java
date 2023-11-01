package racingcar.controller;

import racingcar.domain.Game;

public class GameController {

    private static final Game game = new Game();

    public static void startGame() {
        game.raceSetting();
        game.race();
        game.declareWinner();
    }
}
