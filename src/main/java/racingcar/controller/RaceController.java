package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.OutputRaceView;

public class RaceController {
    private final RaceService raceService = new RaceService();

    public void startRace() {
        raceService.start();
        OutputRaceView.printWinners(raceService.getWinners());
    }
}
