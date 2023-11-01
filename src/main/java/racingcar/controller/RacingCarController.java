package racingcar.controller;

import racingcar.model.Referee;
import racingcar.model.Stadium;

import java.util.stream.IntStream;


public class RacingCarController {
    private final IoController ioController;
    private final Stadium stadium;
    private final Referee referee;

    public RacingCarController() {
        this.ioController = new IoController();
        this.referee = new Referee();
        this.stadium = new Stadium(ioController.raceCarNameInput());
    }

    public void setRace() {
        raceStart();
        raceEnd();
    }

    private void raceStart() {
        ioController.notifyExecutionResult();
        IntStream.range(0, ioController.trialCountInput())
                .forEach(i -> race());
    }

    private void race() {
        stadium.raceOnce();
        referee.updateInfo(stadium.getCars());
        ioController.notifyProgress(referee.getCarProgress());
    }

    private void raceEnd() {
        referee.updateInfo(stadium.getCars());
        String winners = referee.getWinners();
        ioController.notifyWinners(winners);
    }
}
