package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputException;

public final class UserInput {
    public static String[] racingCarsName() {
        System.out.println(Phrases.start);
        return InputException
                .carNameValidation(Console.readLine())
                .split(",");
    }

    public static int racingTimes() {
        System.out.println(Phrases.times);
        return Integer.parseInt(InputException.numberValidation(Console.readLine()));
    }
}
