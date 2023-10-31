package racingcar;


import racingcar.race.RaceController;
import racingcar.race.RaceViewer;

public class Application {
    private static final RaceViewer raceViewer = new RaceViewer();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController raceController = new RaceController(raceViewer);
        raceController.startRace();

    }
}
