package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {

    public Map<String, Integer> racingCarCount() {
        CarName carName = new CarName();
        Map<String, Integer> carMap = carName.getCarList();
        carMap.forEach((key, value)->{
            int count = goControlStatement(getRandomNumber());
            carMap.put(key, value + count);
        });
        return carMap;
    }

    public final int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public final int goControlStatement(int RandomNumber) {
        if (RandomNumber >= 4) {
            return 1;
        }
        return 0;
    }
}
