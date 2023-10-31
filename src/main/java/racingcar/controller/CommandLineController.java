package racingcar.controller;

import racingcar.game.Game;

public class CommandLineController {

    private Game game;

    public CommandLineController(Game game) {
        this.game = game;
    }

    public void start() {
        game.startGame();
    }
}
