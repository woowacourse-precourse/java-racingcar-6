package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.reader.ConsoleInputReader;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsoleInputReader());
        ResultView resultView = new ResultView();

        RaceController raceController = new RaceController(inputView, resultView);
        raceController.startRace();
    }
}
