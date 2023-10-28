package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarName() {
        return Console.readLine();
    }

    public static String getNumberOfRound() {
        return Console.readLine();
    }
}
