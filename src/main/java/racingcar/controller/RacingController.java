package racingcar.controller;

import racingcar.RacingService.RacingService;

import static racingcar.view.OutputView.displayFinishOnce;
import static racingcar.view.OutputView.displayResultHeader;

public class RacingController {

    private RacingService service;
    private int totalRounds;

    public void run() {
        initializeGame();

        displayResultHeader();

        while(gameContinue()) {
            service.playOneRound();
            displayFinishOnce();
        }

    }

    private void initializeGame() {
        service.readyCarName();
        service.readyAttemptCount();
        service.readyCars();

        getTotalRounds();
    }

    private void getTotalRounds() {
        totalRounds = service.getTotalRounds();
    }

    private boolean gameContinue() {
        return totalRounds --> 0;
    }
}
