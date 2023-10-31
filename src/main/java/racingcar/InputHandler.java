package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String userInput() {
        return Console.readLine();
    }

    public String[] splitToArray(String input) {
        validateCarNames(input);
        return input.split(",");
    }

    public int convertToNumber(String input) {
        validateTrialCount(input);
        return Integer.parseInt(input);
    }


}
