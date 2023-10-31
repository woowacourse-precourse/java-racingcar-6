package racingcar.controller;

import racingcar.game.Game;

public class CommandLineController implements Controller{

    private Game game;

    public CommandLineController(Game game) {
        this.game = game;
    }

    @Override
    public void start() {
        game.startGame();
    }
}
