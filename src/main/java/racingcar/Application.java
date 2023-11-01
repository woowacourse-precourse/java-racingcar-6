package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.TypeConvertor;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(inputView());
        controller.run();
    }

    private static InputView inputView() {
        return new InputView(new TypeConvertor());
    }
}
