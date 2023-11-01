package racingcar;

import racingcar.controller.Controller;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.repository.MemoryRacingGameRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;

public class AppConfig {

    public Controller controller() {
        return new Controller(racingGameService(), carService());
    }

    public RacingGameService racingGameService() {
        return new RacingGameServiceImpl(carRepository(), racingGameRepository());
    }

    public CarService carService() {
        return new CarServiceImpl(carRepository());
    }

    public CarRepository carRepository() {
        return new MemoryCarRepository();
    }

    public RacingGameRepository racingGameRepository() {
        return new MemoryRacingGameRepository();
    }
}
