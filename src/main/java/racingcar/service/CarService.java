package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class CarService {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    public static void moveIfRandomNumberExceedsFour(Car car) {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= 4) {
            car.go();
        }
    }
}