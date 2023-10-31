package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Announcer {
    public StringBuilder whoWin(List<Integer> result, List<String> carsName) {
        // 최대값을 찾는 부분
        int maxResult = Integer.MIN_VALUE;
        for (int value : result) {
            if (value > maxResult) {
                maxResult = value;
            }
        }

        // 최대값과 일치하는 인덱스들을 찾는 부분
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == maxResult) {
                maxIndices.add(i);
            }
        }

        //우승자 반환
        StringBuilder winners = new StringBuilder(new String(""));
        winners.append("최종 우승자 : ");
        for (int index : maxIndices) {
            winners.append(carsName.get(index));
            winners.append(", ");
        }
        // 콤마와 공백을 제거
        if(winners.length() > 2) {
            winners.setLength(winners.length() - 2);
        }
        return winners;
    }
}
