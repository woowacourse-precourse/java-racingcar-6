package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.RacingcarView;

import java.util.Map;

public class RacingcarController {
    private final Cars cars;
    private final Validation validation;
    private final RacingcarView racingcarView;

    public RacingcarController(Cars cars, Validation validation, RacingcarView racingcarView) {
        this.cars = cars;
        this.validation = validation;
        this.racingcarView = racingcarView;
    }

    public void runGame() {
        String inputCarName = "";
        String inputNumber = "";

        inputCarName = racingcarView.inputName();
        if (!validation.validationNames(inputCarName)) {
            throw new IllegalArgumentException();
        }

        inputNumber = racingcarView.inputNumber();
        if (!validation.validationNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }

        Map<String, Car> carMap = cars.makeCarList(inputCarName);
        racingcarView.startRacing();

        int inputNumberToInt = Integer.valueOf(inputNumber);
        while (inputNumberToInt > 0) {
            racingResult(carMap);
            inputNumberToInt--;
        }

        racingcarView.announceChampion(cars.findChampionGroup(carMap));
    }

    public void racingResult(Map<String, Car> carList) {
        for (Car car : carList.values()) {
            int distance = car.moveForward();
            racingcarView.racingResult(car.getName(), distance);
        }
        System.out.println();
    }

}
