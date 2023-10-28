package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
    public Map<String, Integer> getcarList() {
        CarName carName = new CarName();
        List<String> carList = carName.inputCarName();
        Map<String, Integer> carMap = new HashMap<>();
        carList.forEach((car)->{
            carMap.put(car, 0);
            System.out.println(carMap);
        });
        return carMap;
    }

    public void racingCarCount() {
        getcarList().forEach((key, value)->{
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
