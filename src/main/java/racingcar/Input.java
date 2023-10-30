package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] carName() {
        String carNameAll = Console.readLine();
        String[] carNameUnit = carNameAll.split(",");
        return carNameUnit;
    }

    public static int gameRound() {
        return Integer.parseInt(Console.readLine());
    }
}
