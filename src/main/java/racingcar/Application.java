package racingcar;

import static racingcar.common.Constant.RAND_NUM_MAX_RANGE;
import static racingcar.common.Constant.RAND_NUM_MIN_RANGE;

import racingcar.controller.GameController;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator =
                new NumberGenerator(RAND_NUM_MIN_RANGE, RAND_NUM_MAX_RANGE);

        GameController gameController = new GameController(inputView, outputView, numberGenerator);

        gameController.run();
    }
}