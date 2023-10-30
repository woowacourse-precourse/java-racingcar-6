package racingcar.domain;

import racingcar.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        this.cars = Arrays.stream(names)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    private Car findFrontPosition() {
        Car maxPosition = cars.get(0); // 초기값으로 첫 번째 자동차를 선택
        for (Car car : cars) {
            if (car.compareTo(maxPosition) > 0) {
                maxPosition = car;
            }
        }
        return maxPosition;
    }


    private List<String> findTiedWinners(Car winner) {
        List<String> tiedWinners = new ArrayList<>();
        for (Car car : cars) {
            if (winner.isSamePosition(car)) {
                tiedWinners.add(car.getName());
            }
        }
        return tiedWinners;
    }


    public void moveCars() {
        RandomNumbersGenerator.randomNumberGenerator(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
