package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameResult {

    public static void getWinner(Map<String, String> racingCars) {
        int maxCarDistance = 0;
        List<String> winner = new ArrayList<>();
        winner = getMaxDistance(racingCars, maxCarDistance, winner);
        OutputView.printGameWinner(winner);
    }

    private static List<String> getMaxDistance(Map<String, String> racingCars, int maxCarDistance, List<String> winner) {
        for (String carName : racingCars.keySet()) {
            if (maxCarDistance == racingCars.get(carName).length()) {
                maxCarDistance = racingCars.get(carName).length();
                winner.add(carName);
            }
            if (maxCarDistance < racingCars.get(carName).length()) {
                maxCarDistance = racingCars.get(carName).length();
                winner.clear();
                winner.add(carName);
            }
        }
        return winner;
    }
}
