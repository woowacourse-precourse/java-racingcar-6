package racingcar.View;

import java.util.List;

public class OutputView {

    public static void gameResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printMovementIndicator(String name, int movement) {
        StringBuilder indicator = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            indicator.append("-");
        }
        System.out.println(name + " : " + indicator.toString());
    }

    public static void printSelectWinner(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        }
        if (winners.size() > 1) {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
