package racingcar.factories;

import racingcar.underhood.Car;
import racingcar.underhood.CarName;
import racingcar.underhood.GameRule;

public class CarFactory {

    public static Car car(GameRule rule, String name) throws IllegalArgumentException {
        return new Car(rule, new CarName(rule, name));
    }
}
