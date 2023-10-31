package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WinnerDecision {

    public static List<String> makeWinnerList(List<Car> carList){
        int maxDistance = checkMaxDistance(carList);

        List<String> winnerList = new ArrayList<>();
        for (Car car : carList){
            if (car.getDistance() == maxDistance){
                winnerList.add(car.getCarName());
            }
        }

        return winnerList;
    }

    public static int checkMaxDistance(List<Car> carList){
        Car carWithMaxDistance = carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get();

        return carWithMaxDistance.getDistance();
    }
}
