package racingcar.factories;

import racingcar.underhood.CarRecord;
import racingcar.underhood.Referee;

public class RefereeFactory {

    public static Referee referee(CarRecord carRecord) {
        return new Referee(carRecord);
    }
}
