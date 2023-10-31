package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.game.Car;

public class Judgment {


    public void checkCarNameUnderFive(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자 보다 긴 자동차 이름이 존재합니다.");
            }
        }
    }

    public void checkCarName(List<String> carNames, String name) {
        checkCarNameIsValid(name);
        checkCarNameUnderFive(carNames);
        checkCarNameSame(carNames);

    }

    public void checkCarNameSame(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
            }
        }
    }

    public void checkCarNameIsValid(String name) {
        if (name.isEmpty() || name.trim().isEmpty() || name.matches(".*,,.*") || name.replaceAll(
                "[,\\s]+", "").isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름이 존재합니다.");
        }


    }

    public String finalCarCheck(Car[] cars) {
        List<Car> maxDistanceCars = maxDistanceCarsCal(cars);

        StringBuilder result = new StringBuilder();
        for (Car car : maxDistanceCars) {
            result.append(car.getName()).append(", ");

        }
        if (!maxDistanceCars.isEmpty()) {
            result.delete(result.length() - 2, result.length()); // 마지막 쉼표와 공백 제거
        }

        return result.toString();
    }

    public List<Car> maxDistanceCarsCal(Car[] cars) {
        int maxDistance = 0;
        List<Car> maxDistanceCars = new ArrayList<>();
        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                maxDistanceCars.clear();
                maxDistanceCars.add(car);
            } else if (distance == maxDistance) {
                maxDistanceCars.add(car);
            }
        }
        return maxDistanceCars;
    }
}
