package racingcar;

import racingcar.domain.ImplementGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ImplementGame implementGame = new ImplementGame();

        Map<String, Integer> numMoveMap = implementGame.playGame();
        List<String> winnerList = getWinner(numMoveMap);
        String prizeWinner = String.join(",", winnerList);
        System.out.println("최종우승자: " + prizeWinner);
    }
    public static List<String> getWinner(Map<String, Integer> numMap) {
        int maxValue = Collections.max(numMap.values());
        List<String> maxValueKeys = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxValueKeys.add(entry.getKey());
            }
        }
        return maxValueKeys;

    }
}
