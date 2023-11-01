package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class RaceUtil {
    public static int raceNumber(String moveTime) {
        return RaceValidate.checkRaceNumber(moveTime);
    }

    public static void race(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber >= 4) {
                car.plusPosition();
            }
        }
    }
}
