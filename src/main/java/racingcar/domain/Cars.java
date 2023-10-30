package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Cars {
    private final List<Car> cars;


    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void raceAllCars() {
        for (Car car : cars) {
            car.goForward();
        }
    }


    public Integer findWinnerPosition() {
        return cars.stream().max(Car::compareTo)
                            .get()
                            .getPosition();
    }

    public List<Car> findWinner(final Integer winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }



    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
