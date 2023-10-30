package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class CarListService {

    public List<String> getWinnerName(List<Car> carList) {
        int winScore = getMaxScore(carList);

        return carList.stream()
                .filter(car -> winScore == car.getCount())
                .map(Car::getCarName)
                .toList();
    }

    private int getMaxScore(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparing(Car::getCount))
                .get()
                .getCount();
    }
}