package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        return Console.readLine();
    }

    public static String inputRacingCount() {
        return Console.readLine();
    }

    public static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }
}
