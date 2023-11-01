package racingcar.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FinalWinner {

    private static final int SOLE_CHAMPION = 1;
    private final List<String> winnerInformation = new LinkedList<>();

    public List<String> getWinnerInformation() {
        return winnerInformation;
    }

    public void carsDistanceComparison(Map<String, String> carsDistanceData, int numberOfAttempts) {

        while (winnerInformation.isEmpty()) {
            maximumMovingCarFind(carsDistanceData, numberOfAttempts);
            numberOfAttempts--;
        }

        if (winnerInformation.size() == SOLE_CHAMPION) {
            new SoleChampion().finalWinnerOutput(winnerInformation);
            return;
        }
        new JointChampion().finalWinnerOutput(winnerInformation);

    }

    private void maximumMovingCarFind(Map<String, String> carsDistanceData, int numberOfAttempts) {
        for (Map.Entry<String, String> carDistanceData : carsDistanceData.entrySet()) {
            if (carDistanceData.getValue().length() == numberOfAttempts) {
                winnerInformation.add(carDistanceData.getKey());
            }
        }
    }

}
