package racingcar.View;

import java.util.List;

public class SystemMessage {
    public static void printResultStart() {
        System.out.println("실행결과");
    }

    public static void printOneGameResult(String carName, int moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String winner = winnersToWinner(winners);
        System.out.print("최종 우승자 : " + winner);
    }

    private static String winnersToWinner(List<String> winners) {
        return String.join(", ", winners);
    }
}
