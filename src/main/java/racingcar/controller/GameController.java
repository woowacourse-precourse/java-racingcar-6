package racingcar.controller;

import racingcar.model.Game;

public class GameController {
    public Game makeRound(String s) {
        return new Game(s);
    }
}
