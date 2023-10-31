package racingcar;

import racingcar.controller.Controller;
import view.inputView.ConsoleInputView;
import view.inputView.InputView;
import view.outputView.OutputView;
import view.outputView.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new OutputViewImpl();
        Controller controller = new Controller(inputView, outputView);
        controller.execute();
    }
}
