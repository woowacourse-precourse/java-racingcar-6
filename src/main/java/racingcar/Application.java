package racingcar;

import controller.GameController;

public class Application {

    public static void main(String[] args) {
        boolean progress = true;

        while(progress) {
            GameController gameController = new GameController();
            progress = gameController.Progress();
        }
    }
}
