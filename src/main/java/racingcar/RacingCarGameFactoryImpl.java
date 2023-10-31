package racingcar;

import racingcar.validator.RacingCarGameMachineValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class RacingCarGameFactoryImpl implements RacingCarGameFactory {
    @Override
    public OutputView outputView() {
        return OutputViewImpl.getInstance();
    }

    @Override
    public InputView inputView() {
        return InputViewImpl.getInstance();
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
        return new RandomNumberGeneratorImpl();
    }

    @Override
    public TimeSleepStrategy timeSleepStrategy() {
        return OneSecondSleepStrategy.getInstance();
    }
}
