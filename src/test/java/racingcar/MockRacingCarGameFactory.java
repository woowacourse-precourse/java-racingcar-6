package racingcar;

import racingcar.validator.RacingCarGameMachineValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MockRacingCarGameFactory implements RacingCarGameFactory {
    @Override
    public OutputView outputView() {
        return MockOutputView.getInstance();
    }

    @Override
    public InputView inputView() {
        return MockInputView.getInstance();
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
        return MockRandomNumberGenerator.getInstance();
    }
}
