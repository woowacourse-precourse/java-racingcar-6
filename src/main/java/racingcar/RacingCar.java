package racingcar;

import racingcar.input.RacingInfoUserInput;
import racingcar.input.UserInput;
import racingcar.race.Handler;
import racingcar.race.RacingInfoHandler;
import racingcar.vo.RacingInfo;

public class RacingCar {

    private final UserInput<RacingInfo> racingInfoInput = new RacingInfoUserInput();
    private final Handler<RacingInfo> racingInfoHandler = new RacingInfoHandler();

    public void run() {
        final RacingInfo racingInfo = racingInfoInput.input();
        racingInfoHandler.execute(racingInfo);
    }
}
