package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.Race;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;

public class Application {
    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleResultView consoleResultView = new ConsoleResultView();

        Race race = new Race();

        RaceController controller = new RaceController(consoleInputView, consoleResultView, race);

        controller.runRace();
    }
}
