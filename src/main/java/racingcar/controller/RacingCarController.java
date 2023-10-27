package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    InputView inputView = new InputView();

    public void startProgram() {
        List<RacingCar> carList = initCars(getCarName());
        int tryNumber = getTryNumber();
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
}
