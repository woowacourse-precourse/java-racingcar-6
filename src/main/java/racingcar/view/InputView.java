package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.Constant;
import racingcar.utils.Validator;

public class InputView {
    public static String getInput() {
        return Console.readLine();
    }

    public static List<String> getCarNames() {
        String carNames = InputView.getInput();
        Validator.checkNameInput(carNames);
        return Arrays.asList(carNames.split(Constant.DELIMITER));
    }

    public static int getAttemptCount() {
        String attemptsCount = InputView.getInput();
        Validator.checkAttemptsCount(attemptsCount);
        return Integer.parseInt(attemptsCount);
    }
}
