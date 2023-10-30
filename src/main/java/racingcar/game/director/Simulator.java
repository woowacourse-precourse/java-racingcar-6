package racingcar.game.director;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.Car;

public class Simulator {

    public Round perRound(List<Car> carList) {
        List<Car> tempList = new ArrayList<>();

        for (Car car : carList) {
            car.drive();
            tempList.add(car);
        }
        return new Round(tempList);
    }
}
