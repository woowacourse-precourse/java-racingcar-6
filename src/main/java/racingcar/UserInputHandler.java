package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {
    private String getUserInput() {
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
