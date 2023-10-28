package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee {
    public List<String> whoIsWinner(Cars cars){
        List<String> winners = new ArrayList<>();
        List<Car> listc = cars.getCars();
        listc.sort(Comparator.comparing(Car::getDistance)
                .thenComparing(Car::getName));
        for (Car car:listc){
            winners.add(car.getName());
        }

        return winners;
    }
}
