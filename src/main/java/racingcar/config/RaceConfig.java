package racingcar.config;

import java.util.List;
import racingcar.domain.Car;
import racingcar.manager.InputManager;
import racingcar.manager.OutputManager;
import racingcar.manager.RaceManager;
import racingcar.service.CarFactory;
import racingcar.service.CarService;

public class RaceConfig {

    public RaceManager getRaceManager() {

        CarFactory carFactory = new CarFactory();
        CarService carService = new CarService();
        List<Car> cars = carFactory.generateCars();
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager(cars);

        return new RaceManager(cars, carService, inputManager,outputManager);
    }
}
