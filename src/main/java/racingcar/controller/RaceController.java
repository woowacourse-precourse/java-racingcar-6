package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Names;
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
        } while (!race.isOver());
        List<String> winners = race.findWinners();
        OutputView.printWinners(winners);
    }

    public void initialize() {
        race = new Race(createRaceCars(), createRaceTryCount());
    }

    public Cars createRaceCars() {
        OutputView.printRaceStart();
        Names carNames = new Names(InputView.inputCarNames());
        return new Cars(carNames);
    }

    public Try createRaceTryCount() {
        OutputView.printRaceTryCount();
        return new Try(InputView.inputTryCount());
    }
}
