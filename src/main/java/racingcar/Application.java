package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(ConsoleInputView.getInstance(), ConsoleOutputView.getInstance());
        raceController.play();
    }
}
