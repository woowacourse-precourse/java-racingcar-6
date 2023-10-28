package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Validator;

public class InputView {
    public List<String> askCarNames() {
        Validator validator = new Validator();
        String names = Console.readLine();
        List<String> carNames = Arrays.asList(names.split(","));

        if (validator.isValidCarNames(carNames)) {
            return carNames;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int askTryCount() {
        String tryCount = Console.readLine();
        Validator validator = new Validator();
        if (validator.isValidTryCount(tryCount)) {
            return Integer.parseInt(tryCount);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
