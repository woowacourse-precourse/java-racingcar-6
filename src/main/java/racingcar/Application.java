package racingcar;


import racingcar.race.RaceController;
import racingcar.race.RaceService;
import racingcar.race.RaceViewer;

public class Application {
    private static final RaceViewer raceViewer = new RaceViewer();
    private static final RaceService raceService = new RaceService();
    public static void main(String[] args) {
        RaceController raceController = new RaceController(raceViewer, raceService);
        raceController.startRace();
    }
}
