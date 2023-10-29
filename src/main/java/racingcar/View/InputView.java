package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNameString() {
        return Console.readLine();
    }

    public static int getTryCount() {
        return Integer.parseInt(Console.readLine());
    }
}
