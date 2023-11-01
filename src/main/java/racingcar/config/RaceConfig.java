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

        final int FORWARD_COUNT = 4;

        List<Car> cars = getCars();
        CarService carService = new CarService(FORWARD_COUNT);
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager(cars);

        return new RaceManager(cars, carService, inputManager, outputManager);
    }

    private List<Car> getCars(){

        CarFactory carFactory = new CarFactory();
        return carFactory.generateCars();
    }
}
