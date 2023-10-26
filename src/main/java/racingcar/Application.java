package racingcar;

import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

public class Application {

    public static void main(String[] args) {
        MessagePrinter messagePrinter = new MessagePrinter();
        MessageReceiver messageReceiver = new MessageReceiver();
        GameManager gameManager = new GameManager(messagePrinter, messageReceiver);
        gameManager.playGame();
    }
}
