package racingcar;

import racingcar.domain.CarListPutInMap;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCount;
import racingcar.domain.RacingValue;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        RacingCount racingCount = new RacingCount();
        CarListPutInMap carListPutInMap = new CarListPutInMap();
        RacingCarName racingCarName = new RacingCarName();
        Referee referee = new Referee();

        racingCarName.inputRacingCarName();
        carListPutInMap.carListPutInMap(RacingValue.racingCarName);
        racingCount.inputRacingCount();
        System.out.println(referee.callWinnerCar());
    }
}
