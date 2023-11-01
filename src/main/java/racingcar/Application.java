package racingcar;

import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.service.JudgingService;
import racingcar.service.JudgingServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new MemoryCarRepository();
        RacingService racingService = new RacingServiceImpl(carRepository);
        JudgingService judgingService = new JudgingServiceImpl(carRepository);

        RacingManager racingManager = new RacingManager(racingService, judgingService);
        racingManager.run();
    }
}
