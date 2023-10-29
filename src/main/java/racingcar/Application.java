package racingcar;

import racingcar.domain.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.gameStart();
    }
}
