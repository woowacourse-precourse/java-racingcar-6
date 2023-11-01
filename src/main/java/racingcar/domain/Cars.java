package racingcar.domain;

import static racingcar.common.response.ErrorCode.CAR_NAME_DUPLICATION;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.common.exception.CustomErrorException;
import racingcar.domain.condition.MoveCondition;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNames(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void racing(MoveCondition condition) {
        for (Car car : cars) {
            car.move(condition.isMove());
        }
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> winningCarNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.INIT_POSITION);
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
