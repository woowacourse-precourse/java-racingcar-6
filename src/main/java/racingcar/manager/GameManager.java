package racingcar.manager;

import static racingcar.model.RandomNumberGenerator.isRacingCarProceed;

public class GameManager {

    private final IOManager ioManager;
    private RacingCarManager racingCarManager;
    int round;

    public GameManager(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void playRacingGame() {
        setRacingCarManager();

        round = ioManager.getRoundNum();
        ioManager.printGameResultInit();

        while (round > 0) {
            racingCarManager.playOneRound();
            ioManager.printRoundResult(racingCarManager.getScoreBoard());
            round--;
        }

        ioManager.printWinner(racingCarManager.getWinnerNames());
    }

    private void setRacingCarManager() {
        this.racingCarManager = RacingCarManager.ofNames(ioManager.getNames());
    }
}
