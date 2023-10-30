package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.Convert;

public class InputView {
    public static List<String> getCarNames() {
        String carNames = Console.readLine();
        return Convert.stringToListByComma(carNames);
    }

    public static Integer getAttemptNumber() {
        String attemptNumber = Console.readLine();
        return Convert.stringToInteger(attemptNumber);
    }
}
