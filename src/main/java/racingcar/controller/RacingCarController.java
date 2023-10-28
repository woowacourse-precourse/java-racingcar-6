package racingcar.controller;

import racingcar.model.Referee;
import racingcar.model.Stadium;

import java.util.ArrayList;
import java.util.stream.IntStream;


public class RacingCarController {
    private final IoController ioController;
    private Stadium stadium;
    private Referee referee;

    public RacingCarController() {
        this.ioController = new IoController();
    }

    public void raceSet() {
        ArrayList<String> carNames = ioController.raceCarNameInput();
        stadium = new Stadium(carNames);
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
        ioController.notifyProgress(referee.getCarprogress());
    }

    private void raceEnd() {
        referee.updateInfo(stadium.getCars());
        String result = referee.getWinners();
        ioController.notifyWinners(result);
    }
}
