package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String userInput() {
        return Console.readLine();
    }

    public String[] splitInput(String input) {
        if (!isRightCarName(input)) {
            throw new IllegalArgumentException();
        }
        return input.split(",");
    }
}
