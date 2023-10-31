package racingcar.domain;

import racingcar.views.OutputView;

import java.util.ArrayList;

import static racingcar.views.InputView.readUserInput;

public class Game {
    private void inputCarName() {
        try {
            OutputView.printCarNameInputInstruction();
            String userInput = readUserInput();
            String[] carNames = userInput.split(",");
            ArrayList<Car> cars = makeCarList(carNames);
        } catch (IllegalArgumentException exception) {
            inputCarName();
        }
    }

    private ArrayList<Car> makeCarList(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void run() {
        inputCarName();
    }
}
