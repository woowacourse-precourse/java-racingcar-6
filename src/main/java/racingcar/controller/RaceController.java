package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.OutputRaceView;

public class RaceController {
    private final RaceService raceService = new RaceService();

    public void startRace() {
        conductRace();
        displayWinners();
    }

    private void conductRace() {
        raceService.start();
    }

    private void displayWinners() {
        OutputRaceView.printWinners(raceService.getWinners());
    }
}
