package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RacingCars;
import racingcar.domain.ForwardTryCount;
import racingcar.view.RacingTurnsInput;

public class CarRacingApplication {

    RacingController racingController;

    public void runWith(RacingCars racingCars) {

        ForwardTryCount forwardTryCount = getForwardTryCountFromInput();

    }

    private ForwardTryCount getForwardTryCountFromInput() {
        return new ForwardTryCount(RacingTurnsInput.input());
    }

    private void playRacingUntil(ForwardTryCount forwardTryCount) {

        if (forwardTryCount.hasZeroCount()) {
            return;
        }

    }
}
