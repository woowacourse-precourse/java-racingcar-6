package racingcar.model;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDistinctName(cars);
        this.cars = cars;
    }

    private void validateDistinctName(List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        String str = cars.stream()
                .map(Car::getName)
                .toList()
                .toString();
        return str.substring(1, str.length()-1);
    }
}
