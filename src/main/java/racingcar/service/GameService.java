package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.printer.GameGuidePrinter;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final GameGuidePrinter gameGuidePrinter;

    public GameService() {
        this.gameGuidePrinter = new GameGuidePrinter();
    }

    public void startGame() {
        gameGuidePrinter.getCarNameInputMessage();
        String carList = carNameInput();
        String[] cars = groupCarsByName(carList);
        List<Car> cars1 = createCar(cars);
        gameGuidePrinter.getTryCountMessage();
        int tryCount = tryCountInput();
        gameGuidePrinter.getResultMessage();
    }

    private String carNameInput() {
        String carList = Console.readLine();
        return carList;
    }

    private String[] groupCarsByName(String carList) {
        String[] cars = carList.split(",");
        return cars;
    }

    private List<Car> createCar(String[] cars) {
        List<Car> cars1 = new ArrayList<>();

        for (String carName : cars) {
            Car car = new Car();
            car.setName(carName);
            cars1.add(car);
        }

        return cars1;
    }

    private int tryCountInput() {
        String tryCount = Console.readLine();
        return Integer.parseInt(tryCount);
    }
}