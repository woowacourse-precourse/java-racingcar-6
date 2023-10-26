package racingcar.controller;

import racingcar.model.Game;

public class GameController {
    public Game makeGame(String maxRound) {
        return new Game(maxRound);
    }
}
