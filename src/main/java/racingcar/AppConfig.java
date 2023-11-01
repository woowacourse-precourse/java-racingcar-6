package racingcar;

import racingcar.controller.Game;
import racingcar.controller.RacingGame;
import racingcar.repository.RacingMemoryRepository;
import racingcar.repository.RacingRepository;
import racingcar.service.NextStepRandomNumberGenerator;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.service.RandomNumberGenerator;
import racingcar.views.GameInput;
import racingcar.views.GameOutput;
import racingcar.views.RacingGameInputImpl;
import racingcar.views.RacingGameOutImpl;

public class AppConfig {

    public Game game() {
        return new RacingGame(racingService(), gameInput(), gameOutput());
    }

    public RacingRepository racingRepository() {
        return new RacingMemoryRepository();
    }

    public RandomNumberGenerator randomNumberGenerator() {
        return new NextStepRandomNumberGenerator();
    }

    public RacingService racingService() {
        return new RacingServiceImpl(racingRepository(), randomNumberGenerator());
    }

    public GameInput gameInput() {
        return new RacingGameInputImpl();
    }

    public GameOutput gameOutput() {
        return new RacingGameOutImpl();
    }
}
