package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarFactory;
import racingcar.service.CarService;

public class RaceManager {

    private InputManager inputManager;
    private OutputManager outputManager;
    private CarFactory carFactory;
    private CarService carService;
    private List<Car> cars;
    private int tryCount;

    public RaceManager() {

        inputManager = new InputManager();
        carFactory = new CarFactory();
        carService = new CarService();
        tryCount = 0;
    }

    public void startRace() {

        cars = carFactory.generateCars();
        outputManager = new OutputManager(cars);
        tryCount = Integer.parseInt(inputManager.inputTryCount());

        racing();

        outputManager.printWinner();
    }

    private void racing() {

        for (int raceCount = 0; raceCount < tryCount; raceCount++) {
            for (Car car : cars) {
                carService.ForwardOrStop(car);
            }
            outputManager.printInterResult();
        }
    }


}
