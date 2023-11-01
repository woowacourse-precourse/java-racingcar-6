package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.ForwardTryCount;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;
import racingcar.view.OutputMessageView;
import racingcar.view.RacingTurnsInputView;
import racingcar.view.RacingWinnersOutputView;
import racingcar.view.RoundResultOutputView;

public class CarRacingApplication {

    RacingController racingController = new RacingController();

    public void runWith(RacingCars racingCars) {

        playRacingTurnsWith(racingCars);
        String racingWinners = getRacingWinnersFrom(racingCars);

        RacingWinnersOutputView.output(racingWinners);


    }

    private void playRacingTurnsWith(RacingCars racingCars) {

        ForwardTryCount forwardTryCount = getForwardTryCountFromInput();

        OutputMessageView.showExecutionResultMessage();

        while (!forwardTryCount.hasZeroCount()) {

            forwardTryCount.subCount();

            racingController.playRacingWith(racingCars);

            RoundResultOutputView.output(racingCars.showCarsStates());
        }

    }

    private RacingWinners getWinnersFrom(RacingCars racingCars) {
        return racingCars.calculateRacingWinners();
    }

    private ForwardTryCount getForwardTryCountFromInput() {
        return new ForwardTryCount(RacingTurnsInputView.input());
    }

    private String getRacingWinnersFrom(RacingCars racingCars) {
        RacingWinners racingWinners = getWinnersFrom(racingCars);
        return racingWinners.showNamesSplitByComma();
    }

}
