package racingcar;

public interface RacingCarGameFactory {
    default RacingCarGameController racingCarController() {
        return new RacingCarGameController(
                racingCarGameMachine(),
                inputView(),
                outputView());
    }

    default RacingCarGameMachine racingCarGameMachine() {
        return new RacingCarGameMachine(
                racingCarGameMachineValidator(),
                racingCarValidator(),
                randomNumberGenerator());
    }

    OutputView outputView();

    InputView inputView();

    RacingCarGameMachineValidator racingCarGameMachineValidator();

    RacingCarValidator racingCarValidator();

    RandomNumberGenerator randomNumberGenerator();
}
