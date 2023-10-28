package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Car {
    CarName carName = new CarName();
    Map<String, Integer> carList = new HashMap<String, Integer>();

    public void racingCarCount() {
        carList.forEach((key, value)->{
            value += goControlStatement(getRandomNumber());
        });
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
