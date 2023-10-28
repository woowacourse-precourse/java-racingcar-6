package racingcar;

import racingcar.controller.RandomNumberGenerater;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.utils.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController racingController = new RacingController(new Cars(), new Race(), randomNumberGenerater,inputView,outputView);
        racingController.start();
    }
}
