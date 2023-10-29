package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    public static String inputCarNames() {
        return Console.readLine();
    }

    public static String[] splitCarNames(String carNames) {
        return carNames.split(NAME_DELIMITER);
    }
}
