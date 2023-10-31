package racingcar.carRacingGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class MoveOrStop {

    public void moveOrStop(Map<String, Integer> carNameMap) {

        for (Map.Entry<String, Integer> carNameEntry : carNameMap.entrySet()) {
            String carName = carNameEntry.getKey();
            int result = carNameEntry.getValue();
            int randomNum = Randoms.pickNumberInRange(0,9);

            if (randomNum >= 4) carNameMap.put(carName, ++result);
        }
    }
}
