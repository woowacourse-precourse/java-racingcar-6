package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Name;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private final InputValidator validator = new InputValidator();

    public List<Name> readNames() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        return Arrays.stream(input.split(SPLIT_REGEX))
                .map(Name::new)
                .toList();
    }

    public int readTryCount() {
        String input = Console.readLine();
        validator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
