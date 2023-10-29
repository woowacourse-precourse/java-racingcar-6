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
        car = Car.getCar();

        String carNames = carRaceGameView.startGameView();
        carNameSetting(carNames);
    }

    public void carNameSetting(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        car.setCarQuantity(carNameList.size());
        addCarNameToCar(carNameList);

    }

    private List<String> CarNamesToList(String carNames) {
        Validator.carNamesComma(carNames);
        List<String> cartest = Arrays.stream(carNames.split(",")).toList();
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void addCarNameToCar(List<String> carNameList) {
        for (String carName:carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isNull(carName);
            car.addCarItem(carName);
        }
    }






}
