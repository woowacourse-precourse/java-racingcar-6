package racingcar.v3;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class ForwardV3 {

    public int randomNums() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean canForward(int randomsNum) {
        return randomsNum >= 4;
    }

    public void updatePosition(Map<String, Integer> stateMap, String carName) {
        int randomNum = randomNums();
        if (canForward(randomNum)) {
            int currentPosition = stateMap.get(carName);
            stateMap.put(carName, currentPosition + 1);
        }
    }

}
