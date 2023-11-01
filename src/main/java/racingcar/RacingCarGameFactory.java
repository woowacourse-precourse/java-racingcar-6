package racingcar;

import racingcar.validator.RacingCarGameMachineValidator;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface RacingCarGameFactory {
    default RacingCarGameController racingCarController() {
        return new RacingCarGameController.Builder()
                .racingCarGameMachine(racingCarGameMachine())
                .inputView(inputView())
                .outputView(outputView())
                .timeSleepStrategy(timeSleepStrategy())
                .build();
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

    TimeSleepStrategy timeSleepStrategy();
}
