package racingcar;

import racingcar.controller.RaceController;
import racingcar.io.ConsoleInputSource;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsoleInputSource());
        OutputView outputView = new OutputView();
        RaceController raceController = new RaceController(inputView, outputView);

        raceController.startRace();
    }
}
