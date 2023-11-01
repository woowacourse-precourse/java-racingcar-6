package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {
    private String getUserInput() {
        return Console.readLine();
    }

    private String[] userInputSplit(String userInput) {
        return userInput.split(",");
    }
}
