package racingcar;

import racingcar.domain.CarList;
import racingcar.domain.RacingCarName;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        CarList carName = new CarList();
        RacingCarName inputCarName = new RacingCarName();
        Referee referee = new Referee();

        carName.setCarList(inputCarName.inputRacingCarName());
        System.out.println(referee.callWinnerCar());
    }
}
