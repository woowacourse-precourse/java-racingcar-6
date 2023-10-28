package racingcar;

import racingcar.controller.Controller;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        Controller controller = new Controller(view);

        controller.start();
    }
}
