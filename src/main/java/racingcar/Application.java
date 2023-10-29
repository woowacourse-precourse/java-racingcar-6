package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.RacingCarName;
import racingcar.domain.Racing;

public class Application {
    public static void main(String[] args) {
        CarName carName = new CarName();
        RacingCarName inputCarName = new RacingCarName();
        carName.setCarList(inputCarName.inputRacingCarName());
        Racing racing = new Racing();
        racing.racingMoveCount();
    }
}
