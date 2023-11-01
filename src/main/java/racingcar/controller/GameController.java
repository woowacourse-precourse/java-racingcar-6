package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.RaceProgressView;
import racingcar.view.RaceResultView;
import racingcar.view.RaceStartView;

public class GameController {

    private RaceStartView raceStartView = new RaceStartView();
    private RaceProgressView raceProgressView = new RaceProgressView();
    private RaceResultView raceResultView = new RaceResultView();
    private final RaceService raceService = new RaceService();

    public void run() {

        String carName = raceStartView.getCarName();
        String raceLap = raceStartView.getRaceLap();
        raceService.start(carName, raceLap);

        String progress = raceService.getProgress();
        raceProgressView.printRaceProgress(progress);

        String result = raceService.getResult();
        raceResultView.printRaceResult(result);
    }
}
