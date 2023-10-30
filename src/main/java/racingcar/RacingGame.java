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
}
