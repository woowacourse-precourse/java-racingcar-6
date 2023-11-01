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

        List<Car> cars = getCars();
        CarService carService = new CarService(4);
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager(cars);

        return new RaceManager(cars, carService, inputManager, outputManager);
    }

    private List<Car> getCars(){

        CarFactory carFactory = new CarFactory();
        return carFactory.generateCars();
    }
}
