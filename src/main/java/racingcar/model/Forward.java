package racingcar.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
    public List<Integer> moveForward(List<Integer> carScoreList) {
        for (int i = 0; i < carScoreList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                carScoreList.set(i, carScoreList.get(i) + 1);
            }
        }
        return carScoreList;
    }
}
