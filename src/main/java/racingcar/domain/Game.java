package racingcar.domain;

import racingcar.views.OutputView;

import java.util.ArrayList;

import static racingcar.util.ErrorInstruction.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.views.InputView.readUserInput;

public class Game {
    private void inputCarName() {
        try {
            OutputView.printCarNameInputInstruction();
            String userInput = readUserInput();
            String[] carNames = userInput.split(",");
            ArrayList<Car> cars = makeCarList(carNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            inputCarName();
        }
    }

    private ArrayList<Car> makeCarList(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.length() < 1) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
            }
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void run() {
        inputCarName();
    }
}
