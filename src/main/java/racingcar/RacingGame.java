package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RacingGame {
    // todo TDD
    public void executeCondition(Map<String, Integer> carNames) {
        for (String carName : carNames.keySet()) {
            int RandomNum = Randoms.pickNumberInRange(0, 9);
            if (RandomNum < 4) continue;
            int moveCnt = carNames.get(carName);
            carNames.replace(carName, ++moveCnt);
        }
    }

    public int maxValue(int tryCount, Map<String, Integer> carsData) {
        int maxValue = 0;
        for (int i = tryCount; i > 0; i--) {
            if (!carsData.containsValue(i)) continue;
            maxValue = i;
            break;
        }
        return maxValue;
    }
}
