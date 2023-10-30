package racingcar;

import racingcar.domain.CarList;
import racingcar.domain.RacingCarName;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        CarList carList = new CarList();
        RacingCarName racingCarName = new RacingCarName();
        Referee referee = new Referee();

        carList.setCarList(racingCarName.inputRacingCarName());
        System.out.println(referee.callWinnerCar());
    }
}
