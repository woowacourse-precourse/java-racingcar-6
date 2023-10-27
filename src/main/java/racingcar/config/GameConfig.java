package racingcar.config;

import racingcar.GameManager;
import racingcar.view.MessagePrinter;
import racingcar.view.MessageReceiver;

public class GameConfig {

    private GameConfig() {
    }

    public static GameManager buildGameManager() {
        MessagePrinter messagePrinter = new MessagePrinter();
        MessageReceiver messageReceiver = new MessageReceiver();

        return new GameManager(messagePrinter, messageReceiver);
    }
}
