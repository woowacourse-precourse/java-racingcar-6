package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private final InputValidator validator = new InputValidator();

    public List<String> readNames() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        return List.of(input.split(SPLIT_REGEX));
    }

    public int readTryCount() {
        String input = Console.readLine();
        validator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
