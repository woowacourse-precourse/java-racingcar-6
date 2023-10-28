package racingcar;

import racingcar.game.RacingController;
import racingcar.racing.Judgement;
import racingcar.game.InputView;
import racingcar.game.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingGameController = new RacingController(inputView(), outputView(), judgement());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static Judgement judgement() {
        return new Judgement();
    }
}
