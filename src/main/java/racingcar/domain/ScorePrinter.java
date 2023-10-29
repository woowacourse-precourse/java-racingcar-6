package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ScorePrinter {

    private static List<String> winner = new ArrayList<>();

    public void printMidtermScore() {
        CarGame.carDistances.forEach((key, value)
                -> System.out.println(key + " : " + "-".repeat(value)));
    }

    public void printFinalScore() {
        Integer maxDistance = Collections.max(CarGame.carDistances.values());

        for (Map.Entry<String, Integer> entry : CarGame.carDistances.entrySet()) {
            String carName = entry.getKey();
            int distance = entry.getValue();

            if (maxDistance == distance) {
                winner.add(carName);
            }
        }
        System.out.println(readWinner());
    }

    private String readWinner() {
        String winnerMsg = "최종 우승자 : ";
        for (int i = 0; i < winner.size(); i++) {
            winnerMsg += winner.get(i);
            if (i < winner.size() - 1) {
                winnerMsg += ", ";
            }
        }

        return winnerMsg;
    }
}
