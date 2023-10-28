package racingcar;

import racingcar.service.GameService;
import racingcar.service.InputService;
import racingcar.service.MessageService;

public class GameController {
    private final MessageService message = new MessageService();
    private final InputService inputService = new InputService();
    private final GameService gameService = new GameService();

    public void start() {
        message.questionCarName();
        String input = inputService.init();
        inputService.carNames(input);

        message.questionTryNum();
        input = inputService.init();
        inputService.numOfAttempts(input);
        gameService.run();
    }
}
