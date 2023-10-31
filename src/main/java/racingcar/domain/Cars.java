package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String input) {
        return new Cars(parseInput(input));
    }

    private static List<Car> parseInput(String input) {
        String[] names = input.split(",");
        List<Car> carList = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();

        for (String name : names) {
            name = name.trim();
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없음.");
            }
            carList.add(new Car(name));
            nameSet.add(name);
        }

        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator, int threshold) {
        for (Car car : cars) {
            if (randomNumberGenerator.createRandomNumber() >= threshold) {
                car.moveForward();
            }
        }
    }

    public int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
    public List<Car> getCarsByPosition(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
