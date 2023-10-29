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
        String names = Console.readLine();
        String[] nameArr = names.split(",");
        return Arrays.asList((nameArr));
    }

    public static int getNumber() throws IllegalArgumentException {
        printEnterRound();
        String numStr = Console.readLine();
        return Integer.parseInt(numStr);
    }
}
