package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.constants.ConstantMessage;

import java.util.List;

import static racingcar.view.constants.ConstantMessage.ASK_GAME_COUNT;
import static racingcar.view.constants.ConstantMessage.ASK_MULTIPLE_CAR_NAMES;

public class View {
    public static String requestCarsName() {
        printNotice(ASK_MULTIPLE_CAR_NAMES);
        return Console.readLine();
    }

    public static String requestRoundCount() {
        View.printNotice(ASK_GAME_COUNT);
        String request = Console.readLine();
        System.out.println();
        return request;
    }

    public static void printNotice(ConstantMessage notice) {
        System.out.println(notice.getMessage());
    }


    public static void printRoundResults(List<String> messages) {
        messages.forEach(System.out::println);
        System.out.println();
    }

}
