package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String userInput() {
        return Console.readLine();
    }

    public String[] splitToArray(String input) {
        if (!isRightCarName(input)) {
            throw new IllegalArgumentException();
        }
        return input.split(",");
    }

    public int convertToNumber(String input) {
        if (!isRightTrialCount(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
