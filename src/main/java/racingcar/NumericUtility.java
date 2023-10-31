package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class NumericUtility {

    public static int generateRandomNumber() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number;
    }

    public static boolean isNumberGreaterOrEqualToFour(int number) {
        return number >= 4;
    }

    public static int getConvertedNumber() {
        int number = generateRandomNumber();
        if (isNumberGreaterOrEqualToFour(number)) {
            return 1;
        }
        return 0;
    }

    public static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            int carPosition = car.getPosition();
            if (carPosition > maxPosition) {
                maxPosition = carPosition;
            }
        }
        return maxPosition;
    }
}
