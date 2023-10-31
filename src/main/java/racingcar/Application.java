package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(new InputView());

        raceController.run();
    }
}
