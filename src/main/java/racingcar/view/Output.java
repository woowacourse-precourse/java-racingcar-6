package racingcar.view;

import java.util.List;

public class Output {
    public static void printResultTitle() {
        System.out.println("\n실행 결과");

    }

    public static void printRoundResult(List<String> carNames, List<Integer> carMoves) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            String moveTrack = "-".repeat(carMoves.get(i));
            System.out.printf("%s : %s\n", carName, moveTrack);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }
}
