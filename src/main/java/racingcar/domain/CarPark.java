package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.vo.Car;

public class CarPark {
    private List<Car> park;

    public CarPark(List<Car> park) {
        this.park = park;
    }

    public List<String> makeNameList() {
        return park.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getPark() {
        return park;
    }

    public void UpdateCarParkState(List<Car> park) {
        this.park = park;
    }

    public void printCarScores() {
        for (Car car : park) {
            System.out.println(car.getScoreBoard());
        }
    }
}
