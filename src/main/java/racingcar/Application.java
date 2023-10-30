package racingcar;

public class Application {
    public static void main(String[] args) {
        InstanceContainer container = new InstanceContainer();
        GameHandler gameHandler = container.getGameHandler();
        gameHandler.handle();
    }
}
