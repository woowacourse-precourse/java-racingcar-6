package racingcar.controller;

import racingcar.model.Stadium;

import java.util.ArrayList;


public class RacingCarController {
    private final IoController ioController;
    private Stadium stadium;

    public RacingCarController() {
        this.ioController = new IoController();
    }

    public void raceSet() {
        ArrayList<String> carNames = ioController.raceCarNameInput();
        stadium = new Stadium(carNames);
        int trialCount = ioController.trialCountInput();
        raceStart(trialCount);
    }

    private void raceStart(int trialCount) {
        ioController.notifyExecutionResult();
        for (int i = 0; i < trialCount; i++) {
            stadium.go();
            String progress = stadium.getProgress();
            ioController.notifyOneRoundCarResult(progress);
        }
        raceEnd();
    }
    private void raceEnd() {
        String result = stadium.getWinners();
        ioController.notifyWinners(result);
    }
}
