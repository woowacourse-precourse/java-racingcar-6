package racingcar;

import racingcar.Controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController racingGame = new GameController();
        racingGame.run();
    }
}
