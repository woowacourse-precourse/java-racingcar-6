package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceUtil {
    public static int raceNumber(String moveTime) {
        return RaceValidate.checkRaceNumber(moveTime);
    }

    public static void movePosition(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber >= 4) {
                car.plusPosition();
            }
        }
    }

    public static List<String> getWinner(List<Car> cars) {
        List<String> result = new ArrayList<>();
        int maxNum = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxNum) {
                result.add(car.getName());
            }
        }
        return result;
    }
}
