package racingcar.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CARS_COUNT = 2;
    private List<Car> cars;
    private Cars(List<Car> cars) {
        validateCarCount(cars);
        validateDuplicateName(cars);
        this.cars = cars;
    }
    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }
    public static Cars of(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(Car.of(name));
        }
        return new Cars(cars);
    }
    public List<Car> getCars() {
        return cars;
    }
    public void move(List<Integer> values) {
        validateValuesCount(values);
        for (int i = 0; i < cars.size(); i ++) {
            cars.get(i).move(values.get(i));
        }
    }
    private void validateCarCount(List<Car> cars) {
        if (cars.size() < MIN_CARS_COUNT) {
            throw new IllegalArgumentException("자동차는 두 대 이상이어야 합니다.");
        }
    }
    private void validateDuplicateName(List<Car> cars) {
        List<String> carsNameList = new ArrayList<>();
        cars.forEach((s)->carsNameList.add(s.getName()));
        Set<String> carsNameSet = new HashSet<>(carsNameList);
        if (carsNameSet.size() != carsNameList.size()) {
            throw new IllegalArgumentException("자동차는 중복된 이름을 가질 수 없습니다.");
        }
    }
    private void validateValuesCount(List<Integer> values) {
        if (cars.size() != values.size()) {
            throw new IllegalArgumentException("값의 개수와 자동차의 개수가 같아야 합니다. ");
        }
    }
}
