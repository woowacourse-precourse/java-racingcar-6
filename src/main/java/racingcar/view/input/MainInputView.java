package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class MainInputView {
    private static final String CARNAME_SPLIT_DELIMETER = ",";

    private MainInputView() {
    }

    public static List<String> readCarNames() {
        return Arrays.asList(Console.readLine().split(CARNAME_SPLIT_DELIMETER));
    }
}
