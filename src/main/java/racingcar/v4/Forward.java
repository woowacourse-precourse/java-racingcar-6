package racingcar.v4;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Forward {
    public int randomNums() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean canForward(int randomsNum) {
        return randomsNum >= 4;
    }

    public void updatePosition(Map<String, Integer> racingStateMap, String carName) {
        int randomNum = randomNums();
        if (canForward(randomNum)) {
            int currentPosition = racingStateMap.get(carName);
            racingStateMap.put(carName, currentPosition + 1);
        }
    }


}
