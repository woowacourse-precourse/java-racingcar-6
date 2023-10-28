package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingUtil {
    public static int generateRandomPower() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Car> createCarsFromNames(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
