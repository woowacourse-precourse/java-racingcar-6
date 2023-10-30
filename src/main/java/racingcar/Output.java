package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String IS = " : ";
    private static final String BAR = "-";
    private static final String COMMA_BLANK = ", ";
    private static final String FINAL_WINNER = "최종우승자" + IS;

    public void printRacingProcess(Map<String, Integer> carNameAndMoving) {
        for (String carName : carNameAndMoving.keySet()) {
            int count = carNameAndMoving.get(carName);
            System.out.println(carName + IS + appendBar(count));
        }
        System.out.println();
    }

    public void printRacingWinner(Map<String, Integer> carNameAndMoving) {
        int maxMoving = getCarWithsMaxMoving(carNameAndMoving);
        List<String> winnerList = getWinnerList(carNameAndMoving, maxMoving);
        String winners = String.join(COMMA_BLANK, winnerList);
        System.out.println(FINAL_WINNER + winners);
    }

    private StringBuilder appendBar(int count) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            bar.append(BAR);
        }
        return bar;
    }

    private int getCarWithsMaxMoving(Map<String, Integer> carNameAndMoving) {
        int maxMoving = 0;
        for (int moving : carNameAndMoving.values()) {
            maxMoving = Math.max(maxMoving, moving);
        }
        return maxMoving;
    }

    private List<String> getWinnerList(Map<String, Integer> carNameAndMoving, int maxMoving) {
        List<String> winnerList = new ArrayList<>();
        for (String carName : carNameAndMoving.keySet()) {
            if (carNameAndMoving.get(carName) == maxMoving) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }
}