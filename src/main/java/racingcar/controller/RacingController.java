package racingcar.controller;

import racingcar.domain.Racing;

public class RacingController {

    public void startRacing() {
        Racing racing = new Racing();
        racing.prepareRacing();
    }

}
