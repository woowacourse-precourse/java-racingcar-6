package racingcar.race;

import racingcar.vo.RacingInfo;

public class RacingInfoHandler implements Handler<RacingInfo>{
    private final RacingCarHandler racingCarHandler = new RacingCarHandler();
    private final RacingResultHandler racingResultHandler = new RacingResultHandler();

    @Override
    public void execute(RacingInfo racingInfo) {
        racingCarHandler.execute(racingInfo);
        racingResultHandler.execute(racingInfo.getCarCollection());
    }
}
