package racingcar.controller;

import racingcar.util.MoveCar;
import racingcar.util.ValidateCarName;
import racingcar.util.ValidateTryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> carList;
    private int tryCount;

    public Game() {
        this.carList = new ArrayList<>();
        this.tryCount = 0;
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

    public void InputTryCount() {
        String Input = InputView.inputTryCount();
        this.tryCount =  ValidateTryCount.validateInputValue(Input); //예외시 IllegalArgumentException
    }

    public void processRound(){

        for (int i = 0; i < tryCount; i++) {
            moveCar();
            printResult();
        }

    }

    public void moveCar() {

        for (Car car : carList) {
            MoveCar.moveCar(car);
        }

    }

    public void printResult() {
        OutputView.printResult(carList);
    }

}
