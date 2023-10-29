package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNames() {
        String carNames = Console.readLine();
        return carNames;
    }

    public static String getTryCount() {
        String tryCountString = Console.readLine();
        return tryCountString;
    }
}