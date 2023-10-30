package racingcar;

public class RacingCarGameFactoryImpl implements RacingCarGameFactory{
    @Override
    public OutputView outputView() {
        return new OutputViewImpl();
    }

    @Override
    public InputView inputView() {
        return new InputViewImpl();
    }

    @Override
    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGeneratorImpl();
    }
}
