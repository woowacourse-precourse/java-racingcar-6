package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.ListOfCar;
import racingcar.model.Car;

public class Race {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public static void advance(Car car) {
        int gauge = car.getGauge();
        car.setGauge(++gauge);
    }

    public static void race(ListOfCar cars) {
        for (Car car : cars.getList()) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (number > 3) {
                advance(car);
            }
        }
    }
}
