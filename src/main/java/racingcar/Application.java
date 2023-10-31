package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(InputView.getInstance(), OutputView.getInstance());
        raceController.play();
    }
}
