package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameWinner {

    public static void getWinner(Map<String, String> carNamesMap) {
        int maxCarValue = 0;
        List<String> winner = new ArrayList<>();
        winner = isWinner(carNamesMap, maxCarValue, winner);
        OutputView.printGameWinner(winner);
    }

    private static List<String> isWinner(Map<String, String> carNamesMap, int maxCarValue, List<String> winner) {
        for (String carName : carNamesMap.keySet()) {
            if (maxCarValue == carNamesMap.get(carName).length()) {
                maxCarValue = carNamesMap.get(carName).length();
                winner.add(carName);
            }
            if (maxCarValue < carNamesMap.get(carName).length()) {
                maxCarValue = carNamesMap.get(carName).length();
                winner.clear();
                winner.add(carName);
            }
        }
        return winner;
    }
}
