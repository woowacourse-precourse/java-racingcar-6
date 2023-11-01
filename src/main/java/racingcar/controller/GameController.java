package racingcar.controller;

public class GameController {
    private GameController() {
    }

    private static class LazyHolder {
        public static final GameController instance = new GameController();
    }

    public static GameController getInstance(){
        return LazyHolder.instance;
    }

    public void newGame(){

    }
}
