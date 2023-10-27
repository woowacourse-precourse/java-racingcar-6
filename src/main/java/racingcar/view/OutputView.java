package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printSingleResult(final String singleResult) {
        System.out.println(singleResult);
    }

    public static void printWinners(final List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winners));
    }
}
