package racingcar;

import racingcar.controller.PlayGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlayGameController playGameController = new PlayGameController();

        playGameController.gameStart();
    }
}
