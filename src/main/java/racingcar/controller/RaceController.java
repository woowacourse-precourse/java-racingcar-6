package racingcar.controller;

import java.util.List;
import java.util.logging.Logger;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceController {

    public static final String LOGGERNAME = "RacingCar Logger";
    Logger logger = Logger.getLogger(LOGGERNAME);

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
        Race race = startRace();
        logger.info("경주가 시작되었습니다: " + race.toString());
    }

    private Race startRace() {
        List<String> raceInfo = raceView.startRace();
        return raceService.startRace(raceInfo);
    }
}
