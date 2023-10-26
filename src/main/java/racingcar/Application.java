package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.race.RaceChecker;
import racingcar.domain.util.NumberGenerator;
import racingcar.domain.util.RandomNumberGenerator;
import racingcar.service.CarService;
import racingcar.service.RacingCarGameService;
import racingcar.usecase.RacingCarUseCase;
import racingcar.view.RacingCarView;

public class Application {
    private static final int RANDOM_MIN_INCLUSIVE = 0;
    private static final int RANDOM_MAX_INCLUSIVE = 9;

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator(RANDOM_MIN_INCLUSIVE, RANDOM_MAX_INCLUSIVE);
        RaceChecker raceChecker = new RaceChecker();

        RacingCarUseCase racingCarUseCase = new RacingCarUseCase(
                new CarService(generator),
                new RacingCarGameService(raceChecker),
                new RacingCarView(),
                new RacingCarController()
        );

        racingCarUseCase.play();
    }
}
