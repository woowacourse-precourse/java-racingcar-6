package racingcar.view;

import java.util.List;

public class GameOutputView {

    public static void printCarPositions(String positions) {
        System.out.println(positions);
    }

    public static void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printResultsHeader() {
        System.out.println("\n실행 결과");
    }
}
