package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GameWinner {

    public static void getWinner(Map<String, String> carNamesMap) {
        String maxCarValue = "0";
        for (String carName : carNamesMap.keySet()) {
            List<String> winner = isWinner(carNamesMap, carName, maxCarValue);
        }
        OutputView.
    }

    private static List<String> isWinner(Map<String, String> carNamesMap, String carName, String maxCarValue) {
        List<String> winner = Arrays.asList(carName);
        if (maxCarValue.compareTo(carNamesMap.get(carName)) == 0) {
            winner.add(carName);
        }
        if (maxCarValue.compareTo(carNamesMap.get(carName)) < 0) {
            winner.clear();
            winner.add(carName);
        }
        return winner;
    }
}
