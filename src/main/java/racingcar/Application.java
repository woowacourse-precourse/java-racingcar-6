package racingcar;

import controller.GameController;

public class Application {
    private static final String EXIT_GAME = "게임 종료";

    public static void main(String[] args) {
        boolean progress = true;

        while(progress) {
            GameController gameController = new GameController();
            progress = gameController.Progress();
        }
        System.out.println(EXIT_GAME);
    }
}
