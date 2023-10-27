package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        List<RacingCar> carList = initCars(getCarName());
        int tryNumber = getTryNumber();
        startRace(carList, tryNumber);
    }

    private List<String> getCarName() {
        return inputView.inputCarName();
    }

    private List<RacingCar> initCars(List<String> nameList) {
        List<RacingCar> carList = new ArrayList<>();
        for(String name : nameList) {
            carList.add(new RacingCar(name));
        }
        return carList;
    }

    private int getTryNumber() {
        return inputView.inputTryNumber();
    }

    private void startRace(List<RacingCar> carList, int tryNumber) {
        outputView.outputExecutionResult();
        for(; tryNumber > 0; tryNumber--) {
            moveEachCar(carList);
            printMoveResult(carList);
        }
    }

    private void moveEachCar(List<RacingCar> carList) {
        for(RacingCar car : carList) {
            car.moveCar();
        }
    }

    private void printMoveResult(List<RacingCar> carList) {
        for(RacingCar car : carList) {
            outputView.outputMoveResult(car.getName(), car.getDashString());
        }
    }
}
