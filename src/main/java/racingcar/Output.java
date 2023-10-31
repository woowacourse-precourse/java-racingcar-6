package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

public class Output {
    public static final String RACING_RESULT = "실행 결과";

    private static final String IS = " : ";
    private static final String BAR = "-";
    private static final String COMMA_AND_BLANK = ", ";
    private static final String FINAL_WINNER = "최종 우승자" + IS;

    public void printRacingProcess(Map<String, Integer> carNameAndMoving) {
        for (String carName : carNameAndMoving.keySet()) {
            int count = carNameAndMoving.get(carName);
            System.out.println(carName + IS + appendBar(count));
        }
        System.out.println();
    }

    public void printRacingWinner(Map<String, Integer> carNameAndMoving) {
        int maxMoving = findMaxMoving(carNameAndMoving);
        List<String> winners = getWinners(carNameAndMoving, maxMoving);
        String winner = String.join(COMMA_AND_BLANK, winners);
        System.out.print(FINAL_WINNER + winner);
    }

    private StringBuilder appendBar(int count) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            bar.append(BAR);
        }
        return bar;
    }

    private int findMaxMoving(Map<String, Integer> carNameAndMoving) {
        int maxMoving = 0;
        for (int moving : carNameAndMoving.values()) {
            maxMoving = Math.max(maxMoving, moving);
        }
        return maxMoving;
    }

    private List<String> getWinners(Map<String, Integer> carNameAndMoving, int maxMoving) {
        return carNameAndMoving.entrySet().stream()
                .filter(name -> name.getValue() == maxMoving)
                .map(Map.Entry::getKey)
                .collect(toList());
    }
}