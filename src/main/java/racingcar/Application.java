package racingcar;

import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumberGenerater;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new Cars(), new Race(), new RandomNumberGenerater(),
                new InputView(), new OutputView(), new InputValidator());
        racingController.start();
    }
}
