package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.RaceCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    private RaceCars raceCars;
    private Integer gameCount;
    private String[] carNames;

    public void start() {
        InputCarsName();
        prepareRacingCars(carNames);
        InputGameCount();
        moveCars();
        decideWinner();
    }

    private void InputCarsName() {
        carNames = InputView.inputCarName();
    }

    private void prepareRacingCars(String[] carNames) {
        List<Car> racingCarList = new ArrayList<>();
        for (String carName : carNames) {
            Car prepareCar = new Car(carName);
            racingCarList.add(prepareCar);
        }
        raceCars = new RaceCars(racingCarList);
    }

}