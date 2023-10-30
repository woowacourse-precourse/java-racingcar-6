package racingcar;

import racingcar.Controller.Controller;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.run();
    }
}
