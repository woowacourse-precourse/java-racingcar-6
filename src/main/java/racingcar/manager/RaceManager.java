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

    public RaceManager(List<Car> cars, CarService carService, InputManager inputManager, OutputManager outputManager) {

        this.cars = cars;
        this.carService = carService;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.tryCount = 0;
    }

    public void start() {

        raceRepeatByTryCount();
        outputManager.printWinner();
    }

    private void raceRepeatByTryCount() {

        tryCount = inputManager.inputTryCount();

        System.out.println("\n실행 결과");
        for (int raceCount = 0; raceCount < tryCount; raceCount++) {
            race();
        }
    }

    private void race() {
        for (Car car : cars) {
            carService.ForwardOrStop(car);
        }
        outputManager.printInterResult();
    }
}
