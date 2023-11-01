package racingcar.Exception;

import java.util.List;

public class UserInputException {
    public void validateIsNumber(String userInput) {
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarNameLength(List<String> carList) {
        for (String carName : carList) {
            int length = carName.length();
            if(length > 5 || length == 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
