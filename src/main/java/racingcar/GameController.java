package racingcar;

import racingcar.service.CheckService;
import racingcar.service.InputService;
import racingcar.service.MessageService;

public class GameController {
    private final MessageService message = new MessageService();
    private final CheckService checkService = new CheckService();

    private final InputService inputService = new InputService();

    public void start() {
        message.questionCarName();

        message.questionTryNum();
        inputService.numOfAttempts();

        message.printResult();
        message.printWinner();
    }
}
