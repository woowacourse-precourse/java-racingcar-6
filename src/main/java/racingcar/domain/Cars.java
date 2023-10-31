package racingcar.domain;

import static racingcar.common.response.ErrorCode.CAR_NAME_DUPLICATION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.common.exception.CustomErrorException;

public class Cars {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNames(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void racing() {
        for (Car car : cars) {
            int number = createRandomNumber();
            car.move(number);
        }
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> winningCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private void validateNames(List<String> names) {
        if (isDuplicatedNames(names)) {
            throw new CustomErrorException(CAR_NAME_DUPLICATION);
        }
    }

    private boolean isDuplicatedNames(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return names.size() != set.size();
    }
}
