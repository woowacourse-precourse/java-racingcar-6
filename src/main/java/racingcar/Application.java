package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.run();
    }
}
