package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.view.OutputView.printInputCarName;

public class InputView {

    private final static String SPLIT_REGEX = "\\s*,\\s*";
    private final static int SPLIT_LIMIT = -1;

    public List<String> getNames() {
        printInputCarName();
        String input = Console.readLine();
        return parseNames(input);
    }

    protected List<String> parseNames(String input) {
        String[] names = input.split(SPLIT_REGEX, SPLIT_LIMIT);
        return new ArrayList<>(Arrays.asList(names));
    }
}
