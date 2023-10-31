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
        RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator validator = new InputValidator();
        RacingController racingController = new RacingController(new Cars(), new Race(), randomNumberGenerater,inputView,outputView, validator);
        racingController.start();
    }
}
