package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindWinner {

    public int findMax(List<Integer> moveInfo) {
        return Collections.max(moveInfo);
    }

    public List<String> getWinnerInfo(List<Integer> moveInfo, List<String> cars) {
        List<String> result = new ArrayList<>();
        int max = findMax(moveInfo);
        for (int i = 0; i < moveInfo.size(); i++) {
            if (moveInfo.get(i) == max) {
                result.add(cars.get(i));
            }
        }
        return result;
    }
}
