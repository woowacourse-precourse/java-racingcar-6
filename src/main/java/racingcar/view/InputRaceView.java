package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constants;

public class InputRaceView {
    public static String readCarNames() {
        System.out.println(Constants.CAR_NAME_PROMPT);
        return Console.readLine();
    }

    public static int readRaceCount() {
        System.out.println(Constants.RACE_COUNT_PROMPT);
        return Integer.parseInt(Console.readLine());
    }
}