package racingcar;

import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

public class GameManager {

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void playGame() {
        prepareGame();
    }

    private void prepareGame() {
        messagePrinter.printCarNameInputMessage();
        messageReceiver.receiveCarName();
    }
}
