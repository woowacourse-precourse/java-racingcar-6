package racingcar;

import racingcar.domain.CarManager;
import racingcar.controller.RacingCarGameController;
import racingcar.util.RandomNumber;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RandomNumberGenerator randomNumberGenerator = new RandomNumber();
        CarManager carManager = new CarManager(randomNumberGenerator);

        RacingCarGameController gameController = new RacingCarGameController(inputView, outputView, carManager);
        gameController.play();
    }
}
