package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private CarManager carManager;
    private List<Car> carImplList = new ArrayList<Car>();

    public CarRaceGame() {
    }

    public void run() {
        startGame();
    }

    public void startGame() {
        carManager = CarManager.create();
        String carNames = CarRaceGameView.startGameView();
        createCar(carNames);
        carManager.setCarQuantity(carImplList.size());

        String attemptNumberString = CarRaceGameView.attemptNumberView();
        setUpAttemptNumber(attemptNumberString);
    }

    private void createCar(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isSpace(carName);
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
