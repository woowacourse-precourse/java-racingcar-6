package racingcar.io;

import java.util.List;
import java.util.StringJoiner;

import static racingcar.constant.Message.WINNER_MESSAGE;

public class OutputView {
    public void print(String text) {
        System.out.println(text);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printCarPosition(String carName, int position) {
        StringBuilder positionText = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionText.append("-");
        }

        print(String.format("%s : %s", carName, positionText));
    }
    public void printWinners(List<String> winners) {
        StringJoiner winnerNames = new StringJoiner(", ");
        for (String winner : winners) {
            winnerNames.add(winner);
        }

        print(String.format(WINNER_MESSAGE, winnerNames));
    }
}
