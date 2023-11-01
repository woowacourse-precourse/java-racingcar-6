package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.StringUtil;
import racingcar.util.TypeConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(inputView(), outputView());
        controller.run();
    }

    private static InputView inputView() {
        return new InputView(new TypeConvertor());
    }

    private static OutputView outputView() {
        return new OutputView(new StringUtil());
    }
}
