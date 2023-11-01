package racingcar.controller;

import java.util.List;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceController {

    public static final String LOGGERNAME = "RacingCar Logger";

    private static RaceController raceController;
    RaceView raceView;
    RaceService raceService;

    private RaceController() {
        this.raceView = RaceView.getInstance();
        this.raceService = RaceService.getInstance();
    }

    public static RaceController getInstance() {
        if (raceController == null) {
            raceController = new RaceController();
        }
        return raceController;
    }

    public void run() {
        startRace();
    }

    private void startRace() {
        List<String> raceInfo = raceView.startRace();
    }
}
