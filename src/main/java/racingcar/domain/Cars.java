package racingcar.domain;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.util.StringUtils;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> carName) {
        this.cars = toCarList(carName);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> toCarList(List<String> names) {
        List<Car> cars = names.stream().map(Car::new).collect(toList());
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
        System.out.println();
    }

    public String award() {
        return StringUtils.listToString(getWinnerNameList(getMaxMove()));
    }

    private List<String> getWinnerNameList(int maxMove) {
        List<String> winners = cars.stream()
                .filter(car -> car.getMoveDistance() == maxMove)
                .map(Car::getName)
                .collect(toList());
        return winners;
    }

    private int getMaxMove() {
        int maxMove = cars.stream()
                .max(comparingInt(Car::getMoveDistance))
                .map(Car::getMoveDistance)
                .orElse(0);
        return maxMove;
    }
}
