package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constants;

public class Input {
    public static String getCarNames() {
        System.out.println(Constants.CAR_NAMES_PROMPT.<String>getValue());
        String carNames = Console.readLine();
        return carNames;
    }

    public static int getRounds() {
        System.out.println(Constants.ROUNDS_PROMPT.<String>getValue());
        return Integer.parseInt(Console.readLine());
    }
}

