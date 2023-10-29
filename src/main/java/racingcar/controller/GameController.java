package racingcar.controller;

public class GameController {
    public GameController() {
    }

    public static GameController getInstance() {
        return GameController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameController INSTANCE = new GameController();
    }
}
