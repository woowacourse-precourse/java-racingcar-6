package racingcar.factories;

import racingcar.CarRecord;
import racingcar.GameRule;

public class CarRecordFactory {

    public static CarRecord createEmptyCarRecord() {
        return new CarRecord();
    }

    public static CarRecord createCarRecord(GameRule rule, String[] tokens)
            throws IllegalArgumentException {
        CarRecord carRecord = CarRecordFactory.createEmptyCarRecord();
        for (String token: tokens) {
            carRecord.register(CarFactory.car(rule, token));
        }
        return carRecord;
    }
}
