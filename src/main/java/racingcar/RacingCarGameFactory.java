package racingcar;

public interface RacingCarGameFactory {
    default RacingCarGameController racingCarController() {
        return new RacingCarGameController(racingCarGameMachine(), inputView(), outputView());
    }

    default RacingCarGameMachine racingCarGameMachine() {
        return new RacingCarGameMachine(randomNumberGenerator());
    }

    OutputView outputView();
    InputView inputView();
    RandomNumberGenerator randomNumberGenerator();
}
