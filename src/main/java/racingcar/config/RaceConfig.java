package racingcar.config;

import java.util.List;
import racingcar.domain.Car;
import racingcar.manager.InputManager;
import racingcar.manager.RaceManager;
import racingcar.service.CarFactory;
import racingcar.service.CarService;

public class RaceConfig {

    public RaceManager getRaceManager() {

        CarFactory carFactory = new CarFactory();
        InputManager inputManager = new InputManager();
        CarService carService = new CarService();
        List<Car> cars = carFactory.generateCars();

        return new RaceManager(cars, carService, inputManager);
    }
}
