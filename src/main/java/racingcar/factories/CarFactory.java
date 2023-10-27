package racingcar.factories;

import racingcar.Car;
import racingcar.CarName;
import racingcar.GameRule;

public class CarFactory {

    public static Car car(GameRule rule, String name) {
        return new Car(rule, new CarName(name));
    }
}
