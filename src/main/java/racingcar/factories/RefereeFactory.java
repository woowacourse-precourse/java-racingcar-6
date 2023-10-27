package racingcar.factories;

import racingcar.CarRecord;
import racingcar.Referee;

public class RefereeFactory {

    public static Referee referee(CarRecord carRecord) {
        return new Referee(carRecord);
    }
}
