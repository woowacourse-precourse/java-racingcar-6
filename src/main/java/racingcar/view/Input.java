package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.SystemMessage;

public class Input {
    public static String carInputMessage() {
        System.out.println(SystemMessage.GAME_START_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static int moveInputMessage() {
        System.out.println(SystemMessage.INPUT_TRIAL_MESSAGE.getMessage());
        try {
            return Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
