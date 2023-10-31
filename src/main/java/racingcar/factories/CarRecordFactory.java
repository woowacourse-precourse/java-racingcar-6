package racingcar.factories;

import racingcar.underhood.CarRecord;
import racingcar.underhood.GameRule;

public class CarRecordFactory {

    public static CarRecord createEmptyCarRecord(GameRule rule) {
        return new CarRecord(rule);
    }

    public static CarRecord createCarRecord(GameRule rule, String[] tokens)
            throws IllegalArgumentException {
        CarRecord carRecord = CarRecordFactory.createEmptyCarRecord(rule);
        for (String token: tokens) {
            carRecord.register(CarFactory.car(rule, token));
        }
        return carRecord;
    }
}
