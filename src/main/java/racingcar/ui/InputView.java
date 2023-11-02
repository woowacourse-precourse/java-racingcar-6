package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utility.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String SPLITTER = ",";

    public List<String> getNames() {
        String input = getInput();
        Validator.validateInput(input);

        List<String> names = splitNames(input);
        Validator.validateNameList(names);

        return names;
    }

    public Integer getGameCount() {
        String input = getInput();

        Validator.validateInput(input);

        Validator.validateGameCount(input);

        return Integer.parseInt(input);
    }

    private List<String> splitNames(String input) {
        return Arrays.asList(input.split(SPLITTER));
    }
    private String getInput() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
