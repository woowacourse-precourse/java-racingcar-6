package racingcar.domain;

import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.util.ArrayList;

import static racingcar.util.ErrorInstruction.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.util.ErrorInstruction.TRIAL_COUNT_ERROR_MESSAGE;
import static racingcar.views.InputView.readUserInput;

public class Game {
    private Race race;
    private void inputCarName() {
        try {
            OutputView.printCarNameInputInstruction();
            String userInput = readUserInput();
            String[] carNames = userInput.split(",");
            ArrayList<Car> cars = makeCarList(carNames);
            race = new Race(Cars.of(cars));
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

    private void getMoveCount() {
        try {
            OutputView.printTrialCountInstruction();
            String userInput = InputView.readUserInput();
            if (!userInput.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(TRIAL_COUNT_ERROR_MESSAGE.getMessage());
            }
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getMoveCount();
        }
    }

    public void run() {
        inputCarName();
        getMoveCount();
        OutputView.printEmptyLine();
        OutputView.printResultMessage();
    }
}
