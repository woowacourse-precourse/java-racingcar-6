package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printInfo(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public static void racingWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
