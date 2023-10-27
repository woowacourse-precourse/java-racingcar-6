package racingcar.view;

import racingcar.view.constants.Notice;

public class OutputView {
    public static void printNotice(Notice notice) {
        System.out.println(notice.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
