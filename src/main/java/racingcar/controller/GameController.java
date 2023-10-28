package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.printer.GameGuidePrinter;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void start() {
        GameGuidePrinter.getCarNameInputMessage();
        String carList = carNameInput();
        String[] cars = groupCarsByName(carList);
        List<Car> cars1 = createCar(cars);
        GameGuidePrinter.getTryCountMessage();
        int tryCount = tryCountInput();
        GameGuidePrinter.getResultMessage();


        for (int i = 0; i < tryCount; i++) {
            moveCar(cars1);
            GameGuidePrinter.showCarNameAndPosition(cars1);
        }
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

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
//            verification(car);
        }
    }
}