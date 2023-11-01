package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController racingCarGame = new GameController();
        racingCarGame.runGame();
    }
}

