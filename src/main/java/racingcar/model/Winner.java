package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winner {
    public static String findWinners(Map<CarName, Integer> map) {
        int maxScore = findMaxScore(map);
        List<CarName> winningCarNames = findWinningCarNames(map, maxScore);
        return buildWinnersString(winningCarNames);
    }

    //Map을 순환하여 가장큰 스코어를 찾는 함수
    public static int findMaxScore(Map<CarName, Integer> map) {
        int maxScore = 0;
        for (Integer score : map.values()) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    //가장큰 스코어를 찾아 키값을 리스트에 저장하는 함수
    public static List<CarName> findWinningCarNames(Map<CarName, Integer> map, int maxScore) {
        List<CarName> winningCarNames = new ArrayList<>();
        for (Map.Entry<CarName, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxScore) {
                winningCarNames.add(entry.getKey());
            }
        }
        return winningCarNames;
    }

    //리스트를 반복문돌려 2번째 우승자부터 , 찍어서 append해주는 함수
    public static String buildWinnersString(List<CarName> winningCarNames) {
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < winningCarNames.size(); i++) {
            if (i > 0) {
                winners.append(", ");
            }
            winners.append(winningCarNames.get(i));
        }
        return winners.toString();
    }


}
