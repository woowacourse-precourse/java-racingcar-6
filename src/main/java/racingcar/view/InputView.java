package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Splitter;

public class InputView {
    public static String[] inputCarNames() {
        return Splitter.splitName(Console.readLine());
    }
}
