package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void start(){
        GameInputView.printStartMessage();
    }
}
