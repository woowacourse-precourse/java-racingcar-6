package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.util.MessageProcessor;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomsWrapper;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageProcessor messageProcessor = new MessageProcessor();
        RandomNumberGenerator randomNumberGenerator = new RandomsWrapper();
        GameController gameController = new GameController(messageProcessor, new GameService(messageProcessor, randomNumberGenerator));
        gameController.runGame();
    }
}
