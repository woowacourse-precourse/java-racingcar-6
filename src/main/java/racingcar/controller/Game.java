package racingcar.controller;

import racingcar.util.ValidateCarName;
import racingcar.view.InputView;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> carList;

    public Game() {
        this.carList = new ArrayList<>();
    }

    public static Game create() {
        return new Game();
    }

    public List<String> InputCarName() {
        String inputValue = InputView.inputCarName();
        List<String> CarNameList = ValidateCarName.validateInputValue(inputValue);
        return CarNameList;
    }

    public void makeCarList(List<String> carList) {

        for (String carName : carList) {
            Car car = Car.create(carName);
            this.carList.add(car);
        }

    }

}
