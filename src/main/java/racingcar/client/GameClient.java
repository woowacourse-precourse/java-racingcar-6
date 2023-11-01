package racingcar.client;

import racingcar.controller.GameController;
import racingcar.dto.GameDto;

public class GameClient {
    private GameController gameController;

    public GameClient(GameController gameController) {
        this.gameController = gameController;
    }

    public void gameRun() {
        GameDto gameDto = gameController.createGame();
        gameController.gameStart(gameDto);
        gameController.printResult(gameDto);
    }
}
