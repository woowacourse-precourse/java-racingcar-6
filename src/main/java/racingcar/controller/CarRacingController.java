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
    

    private void InputGameCount() {
        gameCount = InputView.inputGameCount();
    }

    private void moveCars() {
        OutputView.printGameResultMessage();
        for (int cnt = 0; cnt < gameCount; cnt++) {
        	raceCars.movingCars();
            for (Car car : raceCars.getRacingCars()) {
                OutputView.printCarName(car.getName());
                OutputView.printCarPosition(car.getPosition());
            }
            OutputView.printNextLine();
        }
    }

    private void decideWinner() {
        int maxDistance = raceCars.getMaxDistance();
        OutputView.printWinner(raceCars.getWinnerNames(maxDistance));
    }

}