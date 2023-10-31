package racingcar.factories;

import racingcar.Car;
import racingcar.CarName;
import racingcar.GameRule;

public class CarFactory {

    public static Car car(GameRule rule, String name) throws IllegalArgumentException {
        return new Car(rule, new CarName(rule, name));
    }
}
