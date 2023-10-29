package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readRacingCarName() {
        String input = Console.readLine();
        InputValidator.validateDelimiter(input);
        return input;
    }

    public String readRepeatCount() {
        String input = Console.readLine();
        InputValidator.validateNumber(input);
        return input;
    }
}
