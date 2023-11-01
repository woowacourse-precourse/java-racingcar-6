package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    public List<Car> getCarsInput(String userInput) {
        String[] splitUserInput = userInputSplit(userInput);
        List<Car> cars = new ArrayList<>();
        for (String carName : splitUserInput) {
            checkCarNameLength(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int getRepeatNumberInput(String userInput) {
        int userInputNumber = convertStringToInteger(userInput);
        checkPositiveValue(userInputNumber);
        return userInputNumber;
    }

    public String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private String[] userInputSplit(String userInput) {
        return userInput.split(",");
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private int convertStringToInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkPositiveValue(int repeatNumber) {
        if (repeatNumber < 0) {
            throw new IllegalArgumentException();
        }
    }
}
