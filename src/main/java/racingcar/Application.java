package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printCarNameMessage();

        Cars cars = new Cars(InputView.readCarNames());
        RacingGameController racingGameController = new RacingGameController(cars.getCars());

        racingGameController.run();
    }
}
