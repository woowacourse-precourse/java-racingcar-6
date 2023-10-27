package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarFactory;
import racingcar.service.CarService;

public class RaceManager {

    private InputManager inputManager;
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
        tryCount = Integer.parseInt(inputManager.inputTryCount());

        racing();

        printWinner();
    }

    private void racing() {

        for (int raceCount = 0; raceCount < tryCount; raceCount++) {
            for (Car car : cars) {
                carService.ForwardOrStop(car);
            }
            printInterResult();
        }
    }

    private void printInterResult() {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getState());
        }
    }

    public void printWinner() {
        Referee referee = new Referee(cars);
        List<String> winners = referee.selectWinner();
        String winnerMessage = String.join(", ", winners);

        System.out.println("\n최종 우승자 : " + winnerMessage);
    }
}
