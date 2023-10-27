package racingcar.view;

import racingcar.view.constants.Notice;

public class OutputView {
    public static void printStaticMessage(Notice notice) {
        System.out.print(notice.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
