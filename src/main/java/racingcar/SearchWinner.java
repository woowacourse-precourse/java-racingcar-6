package racingcar;

import java.util.ArrayList;
import java.util.List;

public class SearchWinner {
    public static List<String> winnerSearch(List<String> carList) {

        List<String> winner = new ArrayList<>();
        int maxDashes = 0;

        for (String car : carList) {
            int dashCount = car.length() - car.replace("-", "").length();

            if (dashCount > maxDashes) {
                maxDashes = dashCount;
                winner.clear();
                winner.add(car);
            } else if (dashCount == maxDashes) {
                winner.add(car);
            }
        }
        return winner;
    }
}
