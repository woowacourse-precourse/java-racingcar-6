package racingcar;

public class RacingCarGameFactoryImpl implements RacingCarGameFactory {
    @Override
    public OutputView outputView() {
        return new OutputViewImpl();
    }

    @Override
    public InputView inputView() {
        return new InputViewImpl();
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
}
