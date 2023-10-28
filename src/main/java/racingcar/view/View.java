package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.constants.Message;

import java.util.List;

import static racingcar.view.constants.Message.*;

public class View {
    public static String requestCarNames() {
        printNotice(ASK_MULTIPLE_CAR_NAMES);
        return Console.readLine();
    }

    public static String requestRoundCount() {
        View.printNotice(ASK_GAME_COUNT);
        String request = Console.readLine();
        System.out.println();
        return request;
    }

    public static void printWinnerNames(List<String> winnerNames) {
        String names = String.join(", ", winnerNames);
        String winnerMessage = String.format(RESPONSE_WINNER_MESSAGE.getMessage(), names);
        System.out.println(winnerMessage);
    }

    public static void printNotice(Message notice) {
        System.out.println(notice.getMessage());
    }

    public static void printRoundResults(List<String> messages) {
        messages.forEach(System.out::println);
        System.out.println();
    }

}
