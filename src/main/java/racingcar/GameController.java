package racingcar;

import racingcar.service.InputService;
import racingcar.service.MessageService;

public class GameController {
    private final MessageService message = new MessageService();
    private final InputService inputService = new InputService();
    String input = "";

    public void start() {
        message.questionCarName();
        input = inputService.init();
        inputService.carNames(input);

        message.questionTryNum();
        input = inputService.init();
        inputService.numOfAttempts(input);

        message.printResult();
        message.printWinner();
    }
}
