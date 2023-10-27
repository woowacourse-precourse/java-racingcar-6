package racingcar;

import racingcar.controller.Controller;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleOutputView(), new ConsoleInputView());
        controller.start();
    }
}
