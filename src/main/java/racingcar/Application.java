package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.console.InputView;
import racingcar.view.console.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(
                new InputView(),
                new OutputView()
        );

        raceController.run();
    }
}
