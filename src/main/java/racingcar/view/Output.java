package racingcar.view;

import racingcar.message.ConsoleMessage;
import java.util.List;

public class Output {
    public static void printPosition(String name, int position) {
        System.out.print(name + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList) {
        StringBuilder winners = new StringBuilder();

        winners.append(ConsoleMessage.WINNER.getMessage());

        for (int i = 0; i < winnerList.size(); i++) {
            winners.append(winnerList.get(i));
            if (i != winnerList.size() - 1) {
                winners.append(", ");
            }
        }
        System.out.print(winners);
    }
}
