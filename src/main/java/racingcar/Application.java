package racingcar;

import racingcar.Controller.MainController;

public class Application {

    public static void main(String[] args) {

        MainController controller = new MainController();
        controller.setCarRacing();
        controller.startRacing();
        controller.winnerCheck();

    }
}
