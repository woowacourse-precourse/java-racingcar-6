package racingcar.input;

import racingcar.vo.CarCollection;
import racingcar.vo.RacingInfo;

public class RacingInfoUserInput implements UserInput<RacingInfo>{
    private final UserInput<CarCollection> carCollectionUserInput;
    private final UserInput<Integer> repeatCountUserInput;

    public RacingInfoUserInput(UserInput<CarCollection> carCollectionUserInput, UserInput<Integer> repeatCountUserInput) {
        this.carCollectionUserInput = carCollectionUserInput;
        this.repeatCountUserInput = repeatCountUserInput;
    }

    @Override
    public RacingInfo input() {
        return new RacingInfo(carCollectionUserInput.input(), repeatCountUserInput.input());
    }
}
