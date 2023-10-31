package racingcar.controller;

import racingcar.view.game.Game;

public class CommandLineController implements Controller{

    private final Game game;

    public CommandLineController(Game game) {
        this.game = game;
    }

    @Override
    public void start() {
        game.startGame();
    }
}