package racingcar.input;

import racingcar.vo.RacingInfo;

public class RacingInfoUserInput implements UserInput<RacingInfo>{
    private final CarCollectionUserInput carCollectionUserInput = new CarCollectionUserInput();
    private final RepeatCountUserInput repeatCountUserInput = new RepeatCountUserInput();

    @Override
    public RacingInfo input() {
        return new RacingInfo(carCollectionUserInput.input(), repeatCountUserInput.input());
    }
}
