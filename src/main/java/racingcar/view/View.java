package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.constants.ConstantMessage;

import java.util.List;

import static racingcar.view.constants.ConstantMessage.ASK_GAME_COUNT;
import static racingcar.view.constants.ConstantMessage.ASK_MULTIPLE_CAR_NAMES;

public class View {
    public static String requestCarsName() {
        printConstantMessage(ASK_MULTIPLE_CAR_NAMES);
        return Console.readLine();
    }

    public static String requestRoundCount() {
        View.printConstantMessage(ASK_GAME_COUNT);
        String request = Console.readLine();
        printNewLine();
        return request;
    }

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static <T> void printListWithNewLine(List<T> messages) {
        messages.forEach(System.out::println);
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
