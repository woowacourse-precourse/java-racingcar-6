package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String SEPARATOR = ",";
    public static List<String> inputNames() {
        OutputView.printNameInputMessage();
        String input = Console.readLine();
        List<String> names = splitToStringList(input);
        return names;
    }

    public static String inputRound() {
        return Console.readLine();
    }

    private static List<String> splitToStringList(String name) {
        return Arrays
                .stream(name.split(SEPARATOR))
                .toList();
    }
}
