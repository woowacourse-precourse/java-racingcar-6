package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;

public class RaceManager {

    private InputManager inputManager;
    private OutputManager outputManager;
    private CarService carService;
    private List<Car> cars;
    private int tryCount;

    public RaceManager(List<Car> cars,CarService carService,InputManager inputManager) {

        this.cars = cars;
        this.carService = carService;
        this.inputManager = inputManager;
        this.tryCount = 0;
    }

    public void start() {

        outputManager = new OutputManager(cars);
        tryCount = Integer.parseInt(inputManager.inputTryCount());

        racing();

        outputManager.printWinner();
    }

    private void racing() {

        System.out.println("\n실행 결과");

        for (int raceCount = 0; raceCount < tryCount; raceCount++) {
            for (Car car : cars) {
                carService.ForwardOrStop(car);
            }
            outputManager.printInterResult();
        }
    }
}
