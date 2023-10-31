package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.ConsoleInputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView consoleInputView = new ConsoleInputView();

        RaceController controller = new RaceController(consoleInputView);

        controller.runRace();
    }
}
