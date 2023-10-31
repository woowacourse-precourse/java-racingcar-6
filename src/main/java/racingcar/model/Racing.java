package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.Utils;

public class Racing {


    public void racingRound(List<Car> carList) {
        for (Car car : carList) {
            car.goForward();
        }
    }

    public int winnerPosition(List<Car> carList) {
        List<Integer> carpositions = new ArrayList<>();
        for (Car car : carList) {
            carpositions.add(car.getCarPosition());
        }
        return Utils.getMaxValue(carpositions);
    }
}
