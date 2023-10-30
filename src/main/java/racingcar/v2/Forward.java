package racingcar.v2;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Forward {

    public int randomNums() {
        int randomsNum = Randoms.pickNumberInRange(0, 9);
        return randomsNum;
    }

    public boolean canForward(int randomsNum) {
        return randomsNum >= 4;
    }

    public void updatePosition(Map<String, Integer> stateMap, String carName) {
        int randomsNum = randomNums();
        if (canForward(randomsNum)) {
            int currentPosition = stateMap.get(carName);
            stateMap.put(carName, currentPosition + 1);
        }
    }

}
