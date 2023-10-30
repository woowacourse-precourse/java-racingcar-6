package racingcar;

import racingcar.domain.Controller;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View.startInputMessage();
        Controller controller = new Controller();
        controller.gameLogic();
    }
}