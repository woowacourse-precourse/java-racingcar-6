package racingcar.controller;

import racingcar.domain.Game;

public class Controller {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();
    private Game game;
}
