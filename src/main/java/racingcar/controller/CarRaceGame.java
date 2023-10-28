package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private static CarRaceGameView carRaceGameView = CarRaceGameView.getCarRaceGameView();
    private static Car car;

    public CarRaceGame() {}

    public void run() {
        startGame();
    }

    public void startGame() {
        String carNames = carRaceGameView.startGameView();
        carNameSetting(carNames);
    }

    public void carNameSetting(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        for (String carName: carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isNull(carName);
        }
        car = Car.getCar();
        car.setCarQuantity(carNameList.size());
        for (String carName:carNameList) {
            car.addCarList(carName);
        }
    }

    private List<String> CarNamesToList(String carNames) {
        System.out.println(Arrays.stream(carNames.split(",")).toList());
        return Arrays.stream(carNames.split(",")).toList();
    }






}
