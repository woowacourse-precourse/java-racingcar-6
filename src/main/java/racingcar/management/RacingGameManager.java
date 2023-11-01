package racingcar.management;

import java.util.List;
import racingcar.car.Car;
import racingcar.carlist.RacingCarList;
import racingcar.numbergeneration.MoveNumberGenerator;

public class RacingGameManager {
    private RacingCarList racingCarList;

    public RacingGameManager(RacingCarList racingCarList) {
        this.racingCarList = racingCarList;
    }
    public void runRace() {
        List<Car> racingCarsList = racingCarList.getRacingCarList();

        racingCarsList.forEach(car -> {
            int numberToMove = MoveNumberGenerator.generateNumber();
            car.move(numberToMove);
        });

    }
}
