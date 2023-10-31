package racingcar;

import racingcar.model.Model;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private final InputView inputView;
    private final OutputView outputView;

    public Application() {
        Model model = new Model();
        inputView = new InputView(model);
        outputView = new OutputView(model);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    private void start() {
        inputView.start();
        outputView.start();
    }
}
