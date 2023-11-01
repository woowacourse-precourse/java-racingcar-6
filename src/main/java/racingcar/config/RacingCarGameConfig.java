package racingcar.config;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.CarManager;
import racingcar.util.RandomNumber;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameConfig {
    public RacingCarGameController gameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RandomNumberGenerator randomNumberGenerator = new RandomNumber();
        CarManager carManager = new CarManager(randomNumberGenerator);

        return new RacingCarGameController(inputView, outputView, carManager);
    }
}


