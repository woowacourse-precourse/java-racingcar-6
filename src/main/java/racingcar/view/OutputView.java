package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String STAGE_RESULT = "-";

    public void printRoundResult(List<String> carNames, List<Integer> carDistances) {
        for (int i = 0; i < carNames.size(); i++) {
            String carDistance = carDistance(carNames.get(i), carDistances.get(i));
            System.out.println(carDistance);
        }
        System.out.println();
    }

    private String carDistance(String carName, int distance) {
        StringBuilder distanceIndicator = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceIndicator.append(STAGE_RESULT);
        }
        return carName + " : " + distanceIndicator;
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}