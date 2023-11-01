package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputSystem {

    public static String[] inputCars() throws IllegalArgumentException {
        var text = Console.readLine();
        var texts = text.split(GameConstants.STRING_SPLIT_TEXT, -1);

        return texts;
    }

    public static Integer inputRaceCount() throws IllegalArgumentException {
        var num = Integer.parseInt(Console.readLine());
        if (num <= 0) {
            throw new IllegalArgumentException();
        }

        return num;
    }
}
