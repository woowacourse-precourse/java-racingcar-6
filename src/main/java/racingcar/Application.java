package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Judgement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingGameController = new RacingController(inputView(), outputView());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
