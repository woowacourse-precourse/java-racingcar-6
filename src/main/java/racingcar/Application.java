package racingcar;

import racingcar.commander.GameHandler;
import racingcar.instance.InstanceContainer;

public class Application {
    public static void main(String[] args) {
        InstanceContainer container = new InstanceContainer();
        GameHandler gameHandler = container.getGameHandler();
        gameHandler.handle();
    }
}
