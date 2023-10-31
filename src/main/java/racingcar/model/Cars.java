package racingcar.model;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        validateCarNamesUnique(carList);
        this.cars = carList;
    }

    public void moveRandomEachCars() {
        for (Car car : cars) {
            car.moveAttempt();
        }
    }

    public Map<String, Integer> getCarsStatus() {
        Map<String, Integer> status = new HashMap<>();
        for (Car car : cars) {
            status.put(car.getName(), car.getPosition());
        }
        return status;
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findCarNamesAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .toList();
    }

    private void validateCarNamesUnique(List<Car> carList) {
        Set<String> seen = new HashSet<>();
        for (Car car : carList) {
            if (!seen.add(car.getName())) {
                throw new IllegalArgumentException("자동차 이름은 중복이 있을 수 없습니다.");
            }
        }
    }
}
