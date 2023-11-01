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

    public String getUserInput() {
        return Console.readLine();
    }

    private String[] userInputSplit(String userInput) {
        return userInput.split(",");
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
