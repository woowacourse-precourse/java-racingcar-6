package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String STAGE_RESULT = "-";

    public void printRoundResult(List<String> carNames, List<Integer> carDistances) {
        for (int i = 0; i < carNames.size(); i++) {
            CarDistance(carNames.get(i), carDistances.get(i));
        }
        System.out.println();
    }

    private void CarDistance(String carName, int distance) {
        StringBuilder distanceIndicator = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceIndicator.append(STAGE_RESULT);
        }
        System.out.println(carName + " : " + distanceIndicator);
    }
}