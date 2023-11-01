package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.Try;
import racingcar.response.RaceResultResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private Race race;

    public void run() {
        initialize();
        play();
    }

    public void play() {
        OutputView.printRaceResult();
        do {
            RaceResultResponse response = race.doRace();
            OutputView.printRace(response);
        } while (race.isOver());
        List<String> winners = race.findWinners();
        OutputView.printWinners(winners);
    }

    public void initialize() {
        Cars cars = getRaceCars();
        Try tryCount = getRaceTryCount();
        race = new Race(cars, tryCount);
    }

    public Cars getRaceCars() {
        OutputView.printRaceStart();
        return new Cars(InputView.inputCarNames());
    }

    public Try getRaceTryCount() {
        OutputView.printRaceTryCount();
        return new Try(InputView.inputTryCount());
    }
}
