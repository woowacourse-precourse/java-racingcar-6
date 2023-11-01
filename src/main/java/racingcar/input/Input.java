package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static void print(InputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printEnterCarNames() {
        print(InputMessage.ENTER_CAR_NAMES);
    }

    public static void printEnterRound() {
        print(InputMessage.ENTER_ROUND);
    }

    public static List<String> getCarNames() {
        printEnterCarNames();
        String nameStr = Console.readLine();
        String[] nameArr = nameStr.split(",");
        InputValidator.isValidCarName(nameArr);
        return Arrays.asList((nameArr));
    }

    public static int getRound() throws IllegalArgumentException {
        printEnterRound();
        String round = Console.readLine();
        InputValidator.isValidRound(round);
        return Integer.parseInt(round);
    }
}
