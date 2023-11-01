package racingcar;

import racingcar.input.UserInput;
import racingcar.race.Handler;
import racingcar.vo.RacingInfo;

public class RacingCar {

    private final UserInput<RacingInfo> racingInfoInput;
    private final Handler<RacingInfo,RacingInfo> racingInfoHandler;

    public RacingCar(UserInput<RacingInfo> racingInfoInput, Handler<RacingInfo,RacingInfo> racingInfoHandler) {
        this.racingInfoInput = racingInfoInput;
        this.racingInfoHandler = racingInfoHandler;
    }

    public void run() {
        final RacingInfo racingInfo = racingInfoInput.input();
        racingInfoHandler.execute(racingInfo);
    }
}
