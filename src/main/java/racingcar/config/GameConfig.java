package racingcar.config;

import racingcar.GameManager;
import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

public class GameConfig {

    private GameConfig() {
    }

    public static GameManager buildGameManager() {
        MessagePrinter messagePrinter = messagePrinter();
        MessageReceiver messageReceiver = messageReceiver();

        return new GameManager(messagePrinter, messageReceiver);
    }

    private static MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }

    private static MessageReceiver messageReceiver() {
        return new MessageReceiver();
    }
}
