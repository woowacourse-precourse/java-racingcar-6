package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Constants;
import racingcar.util.InputViewValidator;

public class InputView {
    private InputView() {
    }

    public static List<String> inputNames() {
        OutputView.printNameInputMessage();

        String input = Console.readLine();

        InputViewValidator.validateInputWithSeparator(input);

        List<String> names = splitToStringList(input);

        InputViewValidator.validateInputCount(names);

        return names;
    }

    public static String inputRound() {
        OutputView.printRoundInputMessage();
        return Console.readLine();
    }

    private static List<String> splitToStringList(String name) {
        return Arrays.stream(name.split(Constants.COMMA)).toList();
    }
}
