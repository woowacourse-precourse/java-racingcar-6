package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceController raceController = new RaceController(inputView, outputView);

        raceController.startRace();
    }
}
