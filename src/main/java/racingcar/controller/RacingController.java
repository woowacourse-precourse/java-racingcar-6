package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class RacingController {

    public void startRacing() {
        Racing racing = new Racing();
        racing.race();
    }

}
