package racingcar.race;

import racingcar.vo.CarCollection;
import racingcar.vo.RacingInfo;

public class RacingInfoHandler implements Handler<RacingInfo, RacingInfo>{
    private final RacingCarHandler racingCarHandler;
    private final RacingResultHandler racingResultHandler;

    public RacingInfoHandler(RacingCarHandler racingCarHandler, RacingResultHandler racingResultHandler) {
        this.racingCarHandler = racingCarHandler;
        this.racingResultHandler = racingResultHandler;
    }

    @Override
    public RacingInfo execute(RacingInfo racingInfo) {
        final RacingInfo racingResult = racingCarHandler.execute(racingInfo);
        final CarCollection carCollection = racingResultHandler.execute(racingResult.getCarCollection());
        return new RacingInfo(carCollection, racingResult.getRepeatCount());
    }
}
