package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> inputCarNames() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }
}
