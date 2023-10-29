package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RandomMovable;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomMovable movable = new RandomMovable(randomNumberGenerator);
        RacingCarController racingCarController = new RacingCarController(inputView, outputView, movable);

        racingCarController.start();
    }
}
