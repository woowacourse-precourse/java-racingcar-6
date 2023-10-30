package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Utils;

public class InputView {
    public static int inputAttemptCount() {
        String attemptCount = Console.readLine();
        return Integer.parseInt(attemptCount);
    }

    public static List<String> inputCarName() {
        String carNames = Console.readLine();
        return Utils.splitAndToList(carNames);
    }

}
