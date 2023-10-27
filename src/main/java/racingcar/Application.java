package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarFactory;
import racingcar.service.CarGameService;
import racingcar.service.RacingCarGameService;
import racingcar.view.CarView;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        CarView carInputView = new RacingCarView();
        String[] carNames = carInputView.inputCarNames();
        int gameCount = carInputView.inputGameCount();

        CarGameService carGameService = new RacingCarGameService(new CarFactory());
        GameController controller = new GameController(carGameService);

        controller.gameRun(carNames, gameCount);

    }
}
