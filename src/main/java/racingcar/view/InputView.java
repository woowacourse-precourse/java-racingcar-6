package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.GameRule;
import racingcar.domain.Validator;

public class InputView {
    public static List<String> readCarName() {
        String carNames = Console.readLine();
        Validator.validateCarNames(carNames);

        String[] splitCarNames = carNames.split(GameRule.DELIM);
        return Arrays.asList(splitCarNames);
    }

    public static int readTryNumber() {
        String tryNumber = Console.readLine();
        Validator.validateTryNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}
