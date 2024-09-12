package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    private final InputValidator validator = new InputValidator();

    public String carName() {
        Output.printStartMessage();
        String input = Console.readLine();
        validator.validateCarNames(input);
        return input;
    }

    public int roundNumber() {
        Output.printCountMessage();
        return validator.parseAndValidateRoundNumber(Console.readLine());
    }
}