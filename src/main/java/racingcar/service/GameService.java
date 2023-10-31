package racingcar.service;

public class GameService {
    private final WinnerDetector winnerDetector = new WinnerDetector();
    private final RaceManager raceManager = new RaceManager();

    public void run() {
        raceManager.racing();
        winnerDetector.find();
    }
}