package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.util.MessageProcessor;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageProcessor messageProcessor = new MessageProcessor();
        GameController gameController = new GameController(messageProcessor, new GameService(messageProcessor));
        gameController.runGame();
    }
}
