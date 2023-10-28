package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    public void racingCarCount() {
        CarName carName = new CarName();
        Map<String, Integer> carNames = carName.getcarList();
        carNames.forEach((key, value)->{
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
