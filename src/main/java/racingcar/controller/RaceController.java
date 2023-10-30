package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.Try;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private Race race;

    public void run() {
        initialize();
    }

    public void initialize() {
        List<String> carNames = getRaceCars();
        int tryCount = getRaceTryCount();
        race = new Race(new Cars(carNames), new Try(tryCount));
    }

    public List<String> getRaceCars() {
        OutputView.printRaceStart();
        return InputView.inputCarNames();
    }

    public int getRaceTryCount() {
        OutputView.printRaceTryCount();
        return InputView.inputTryCount();
    }
}
