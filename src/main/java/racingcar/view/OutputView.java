package racingcar.view;

import java.util.List;
import racingcar.constant.GameMessage;

public class OutputView {
    public static void askCarName() {
        System.out.println(GameMessage.INPUT_CAR_MESSAGE);
    }

    public static void askCount() {
        System.out.println(GameMessage.INPUT_COUNT_MESSAGE);
    }

    public static void startRace() {
        System.out.println(GameMessage.RESULT_MESSAGE);
    }

    public static void printResult(List<String> players, List<Integer> howLong) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i));
            System.out.print(" : ");
            for (int j = 0; j < howLong.get(i); j++) {
                System.out.print("_");
            }
            System.out.println();
        }
    }

    public static void printWinner(List<String> winners) {

        System.out.print(GameMessage.WINNER_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i + 1 != winners.size()) {
                System.out.print(", ");
            }
        }
    }

}
