package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
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
        List<String> carNameList = CarNamesToList(carNames);
        car = Car.getCar();
        car.setCarQuantity(carNameList.size());
        for (String carName:carNameList) {
            car.addCarList(carName);
        }
    }

    private List<String> CarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }






}
