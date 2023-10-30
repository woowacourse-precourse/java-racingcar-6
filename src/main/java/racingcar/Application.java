package racingcar;

import racingcar.domain.CarListPutInMap;
import racingcar.domain.InputRacingCarName;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        CarListPutInMap carList = new CarListPutInMap();
        InputRacingCarName racingCarName = new InputRacingCarName();
        Referee referee = new Referee();

        carList.setCarList(racingCarName.inputRacingCarName());
        System.out.println(referee.callWinnerCar());
    }
}
