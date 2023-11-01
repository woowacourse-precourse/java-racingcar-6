package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Camera;
import racingcar.domain.Judgement;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingCarController racingGameController = new RacingCarController(inputView(), outputView(), race(), camera(), judgement());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static Race race() {
        return new Race();
    }

    private static Camera camera() {
        return new Camera();
    }

    private static Judgement judgement() {
        return new Judgement();
    }
}
