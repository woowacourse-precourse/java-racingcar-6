package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] getCarsByUser() {
        return Console.readLine().split(",");
    }

    public static String getTryCountByUser() {
        return Console.readLine();
    }
}
