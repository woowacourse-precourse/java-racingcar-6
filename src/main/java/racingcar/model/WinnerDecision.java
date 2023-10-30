package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class WinnerDecision {

    public static int checkMaxDistance(List<Car> carList){
        Car carWithMaxDistance = carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get();

        return carWithMaxDistance.getDistance();
    }
}
