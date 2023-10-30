package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {
    private static final String IS = " : ";

    public void printRacingProcess(Map<String, Integer> carNameAndMoving) {
        for (String carName : carNameAndMoving.keySet()) {
            int count = carNameAndMoving.get(carName);
            System.out.println(carName + IS + appendBar(count));
        }
        System.out.println();
    }

    public void printRacingWinner(Map<String, Integer> carNameAndMoving) {
        List<String> winnerList = new ArrayList<>();
        int maxMoving = 0;

        for (int moving : carNameAndMoving.values()) {
            maxMoving = Math.max(maxMoving, moving);
        }
        for (String carName : carNameAndMoving.keySet()) {
            if (carNameAndMoving.get(carName) == maxMoving) {
                winnerList.add(carName);
            }
        }
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }

    private StringBuilder appendBar(int count) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            bar.append("-");
        }
        return bar;
    }
}