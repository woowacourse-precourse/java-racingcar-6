package racingcar;

import racingcar.domain.CarListPutInMap;
import racingcar.domain.InputRacingCarName;
import racingcar.domain.InputRacingCount;
import racingcar.domain.RacingValue;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        InputRacingCount inputRacingCount = new InputRacingCount();
        CarListPutInMap carListPutInMap = new CarListPutInMap();
        InputRacingCarName inputRacingCarName = new InputRacingCarName();
        Referee referee = new Referee();
        RacingValue racingValue = new RacingValue();

        inputRacingCarName.inputRacingCarName();
        carListPutInMap.carListPutInMap(racingValue.racingCarName);
        inputRacingCount.inputRacingCount();
        System.out.println(referee.callWinnerCar());
    }
}
