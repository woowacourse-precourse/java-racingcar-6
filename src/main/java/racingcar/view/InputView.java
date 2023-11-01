package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.GameRule;

public class InputView {
    public static List<String> readCarName() {
        String carNames = Console.readLine();

        String[] splitCarNames = carNames.split(GameRule.DELIM);
        return Arrays.asList(splitCarNames);
    }
}
