package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputRaceViewConstant;

public class InputRaceView {
    public static String readCarNames() {
        System.out.println(InputRaceViewConstant.CAR_NAME_PROMPT);
        return Console.readLine();
    }

    public static int readRaceCount() {
        System.out.println(InputRaceViewConstant.RACE_COUNT_PROMPT);
        return Integer.parseInt(Console.readLine());
    }
}