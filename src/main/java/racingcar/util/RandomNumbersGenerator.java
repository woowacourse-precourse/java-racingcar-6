package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingConstant;
import racingcar.domain.Car;

import java.util.List;

public class RandomNumbersGenerator {

    public static void randomNumberGenerator(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (randomNumber >= RacingConstant.FORWARD_NUMBER.getValue()) {
                car.goToPosition();
                }
            }
        }
    }

