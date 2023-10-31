package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RacingCars;
import racingcar.domain.ForwardTryCount;
import racingcar.domain.RacingWinners;
import racingcar.view.MessageOutputView;
import racingcar.view.RacingTurnsInput;

public class CarRacingApplication {

    RacingController racingController = new RacingController();

    public void runWith(RacingCars racingCars) {

        playRacingTurnsWith(racingCars);
        String racingWinners = getRacingWinnersFrom(racingCars);

        MessageOutputView.outputRacingWinners(racingWinners);


    }

    private void playRacingTurnsWith(RacingCars racingCars) {

        ForwardTryCount forwardTryCount = getForwardTryCountFromInput();

        System.out.println("\n실행결과");

        while (!forwardTryCount.hasZeroCount()) {

            forwardTryCount.subCount();

            racingController.playRacingWith(racingCars);

            MessageOutputView.outputRoundResult(racingCars.showRacingStates());
        }

    }

    private RacingWinners getWinnersFrom(RacingCars racingCars) {
        return racingCars.calculateRacingWinners();
    }

    private ForwardTryCount getForwardTryCountFromInput() {
        return new ForwardTryCount(RacingTurnsInput.input());
    }

    private String getRacingWinnersFrom(RacingCars racingCars) {
        RacingWinners racingWinners = getWinnersFrom(racingCars);
        return racingWinners.showRacingWinnersNamesSplitByComma();
    }

}
