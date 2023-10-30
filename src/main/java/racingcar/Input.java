package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public static String[] carName() {
        String carNameAll = Console.readLine();
        String[] carNameUnit = carNameAll.split(",");
        return carNameUnit;
    }

    public static int gameRound(){
        return Integer.parseInt(Console.readLine());
    }
}
