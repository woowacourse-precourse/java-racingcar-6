package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private static final int MIN_CAR_NUMBER = 2;

    public List<Car> nameForCar(String names) {
        List<String> carsName = separateNames(names);
        List<Car> cars = new ArrayList<>();
        carsName.stream().forEach(name -> cars.add(new Car(name.trim())));
        return cars;
    }

    public List<String> separateNames(String names) {
        String[] carsArray = names.split(",");
        validateAll(names, carsArray);
        List<String> cars = new ArrayList<>(Arrays.asList(carsArray));
        return cars;
    }

    private void validateAll(String names, String[] cars) {
        validateDuplication(cars);
        validateCarCount(names, cars);
        validateGame(cars);
    }

    private void validateGame(String[] cars) {
        if (cars.length < MIN_CAR_NUMBER) {
            throw new IllegalArgumentException("게임을 진행하기 위한 자동차의 개수는 최소 2대 입니다.");
        }
    }

    private void validateCarCount(String names, String[] cars) {
        if (cars.length <= countComas(names)) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 불가능합니다.");
        }
    }

    private long countComas(String names) {
        return names.chars()
                .filter(c -> c == ',')
                .count();
    }

    private void validateDuplication(String[] cars) {
        Set<String> nonDuplicatedCar = Arrays.stream(cars)
                .distinct()
                .collect(Collectors.toSet());
        if (nonDuplicatedCar.size() != cars.length) {
            throw new IllegalArgumentException();
        }
    }
}
