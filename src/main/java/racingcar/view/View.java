package racingcar.view;

import racingcar.view.constants.Notice;

import java.util.List;

public class View {
    public static void printNotice(Notice notice) {
        System.out.println(notice.getMessage());
    }

    public static void printResultList(List<String> messages) {
        messages.forEach(System.out::println);
        System.out.println();
    }
}
