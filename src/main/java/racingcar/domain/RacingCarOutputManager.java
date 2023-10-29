package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class RacingCarOutputManager {

    public void println(String text) {
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

        println(String.format("%s : %s", carName, positionText));
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerNames = new StringJoiner(", ");
        for (String winner : winners) {
            winnerNames.add(winner);
        }

        println(String.format("최종 우승자 : %s", winnerNames));
    }
}
