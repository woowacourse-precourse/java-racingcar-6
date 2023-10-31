package racingcar;

import racingcar.validator.RacingCarGameMachineValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MockRacingCarGameFactory implements RacingCarGameFactory {
    @Override
    public OutputView outputView() {
        return new MockOutputView();
    }

    @Override
    public InputView inputView() {
        return new MockInputView();
    }

    @Override
    public RacingCarGameMachineValidator racingCarGameMachineValidator() {
        return new RacingCarGameMachineValidator();
    }

    @Override
    public RacingCarValidator racingCarValidator() {
        return new RacingCarValidator();
    }

    @Override
    public RandomNumberGenerator randomNumberGenerator() {
        return new MockRandomNumberGenerator();
    }
}
