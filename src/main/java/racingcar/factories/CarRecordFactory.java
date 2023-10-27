package racingcar.factories;

import racingcar.CarRecord;

public class CarRecordFactory {

    public static CarRecord createEmptyCarRecord() {
        return new CarRecord();
    }
}
