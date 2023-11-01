package racingcar.Utils;

import camp.nextstep.edu.missionutils.Console;

public class InputSystem {

    public static String[] inputCars() throws IllegalArgumentException {
        var text = Console.readLine();

        return text.split(GameConstants.STRING_SPLIT_TEXT, -1);
    }

    public static Integer inputRaceCount() throws IllegalArgumentException {
        var num = Integer.parseInt(Console.readLine());
        if (num <= 0) {
            throw new IllegalArgumentException();
        }

        return num;
    }
}
