package racingcar.config;

import racingcar.domain.race.RaceChecker;
import racingcar.domain.util.NumberGenerator;
import racingcar.domain.util.RandomNumberGenerator;
import racingcar.port.output.RacingCarOutputPort;
import racingcar.port.output.console.RacingCarOutputConsoleAdapter;
import racingcar.application.service.CarService;
import racingcar.application.service.RacingCarGameService;
import racingcar.application.usecase.RacingCarUseCase;
import racingcar.view.RacingCarView;

public class RacingCarConfiguration {
    private NumberGenerator numberGenerator() {
        int randomMinInclusive = 0;
        int randomMaxInclusive = 9;

        return new RandomNumberGenerator(randomMinInclusive, randomMaxInclusive);
    }

    private RaceChecker raceChecker() {
        return new RaceChecker();
    }

    private CarService carService(NumberGenerator generator) {
        return new CarService(generator);
    }

    private RacingCarGameService racingCarGameService(RaceChecker raceChecker) {
        return new RacingCarGameService(raceChecker);
    }


    private RacingCarView racingCarView() {
        return new RacingCarView();
    }

    private RacingCarOutputPort racingCarOutputPort() {
        return new RacingCarOutputConsoleAdapter();
    }

    private RacingCarUseCase racingCarUseCase() {
        return new RacingCarUseCase(
                carService(numberGenerator()),
                racingCarGameService(raceChecker()),
                racingCarView(),
                racingCarOutputPort()
        );
    }
}
