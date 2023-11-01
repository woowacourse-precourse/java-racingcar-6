package racingcar.View;

import java.util.List;

public class OutputView {
    public static void gameResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printMovementCount(String name, int movement) {
        String movementIndicator = createMovementIndicator(movement);
        System.out.println(name + " : " + movementIndicator);
    }

    private static String createMovementIndicator(int movement) {
        StringBuilder indicator = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            indicator.append("-");
        }
        return indicator.toString();
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
