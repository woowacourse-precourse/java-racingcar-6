package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final RaceViewer raceViewer = new RaceViewer();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController raceController = new RaceController(raceViewer);
        raceController.startRace();

    }
}
