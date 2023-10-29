package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private static CarRaceGameView carRaceGameView = CarRaceGameView.getCarRaceGameView();
    private CarManager carManager;
    private List<Car> carImplList;

    public CarRaceGame() {}

    public void run() {
        startGame();
    }

    public void startGame() {
        carManager = CarManager.create();
        String carNames = carRaceGameView.startGameView();
        createCar(carNames);

        String attemptNumberString = carRaceGameView.attemptNumberView();
    }

    public void createCar(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        carManager.setCarQuantity(carNameList.size());

        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isNull(carName);
            carImplList.add(new Car(carName));
        }
    }

    private List<String> CarNamesToList(String carNames) {

        return Arrays.stream(carNames.split(",")).toList();
    }


    private void setUpAttemptNumber(String attemptNumberString) {
        carManager.setAttemptNumber(Integer.parseInt(attemptNumberString));
    }





}
