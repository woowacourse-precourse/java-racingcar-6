package racingcar;

import racingcar.controller.RecingcarGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RecingcarGameController recingcarGameController = new RecingcarGameController();

        recingcarGameController.gameStart();
    }
}
