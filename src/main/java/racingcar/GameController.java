package racingcar;

import racingcar.service.MessageService;

public class GameController {
    private final MessageService message = new MessageService();

    public void start() {
        message.questionCarName();

        message.questionTryNum();
        message.printResult();
        message.printWinner();
    }
}
