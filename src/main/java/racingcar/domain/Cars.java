package racingcar.domain;

import racingcar.exception.UserInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.exception.errorcode.UserInputErrorCode.DUPLICATED_NAME;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        validateDuplicate(carList);
        this.carList = carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<String> getWinnerNames() {
        return carList.stream().filter(c -> c.getDistance() == getMaxDistance()).map(Car::getName).toList();
    }

    private int getMaxDistance() {
        return carList.stream().max(Car::compareTo).get().getDistance();
    }

    private void validateDuplicate(final List<Car> carList) {
        final Set<Car> carSet = new HashSet<>(carList);
        if (carSet.size() != carList.size()) {
            throw new UserInputException(DUPLICATED_NAME);
        }
    }
}
