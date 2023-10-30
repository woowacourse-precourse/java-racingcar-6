package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public int countMaxScore(List<Integer> score) {
        return Collections.max(score);
    }

    public List<String> selectWinners() {
        List<String> winnerList = new ArrayList<>();
        int max = countMaxScore(Cars.countList);
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (max == Cars.countList.get(i)) {
                winnerList.add(Cars.carList.get(i));
            }
        }
        return winnerList;
    }

}
