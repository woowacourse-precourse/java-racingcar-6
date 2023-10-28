package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] getCarsByUser() {
        return Console.readLine().split(",");
    }

    public static String getTryCountByUser() {
        return Console.readLine();
    }
}
