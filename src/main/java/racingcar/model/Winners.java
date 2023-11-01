package racingcar.model;

import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final static int MIN_DISTANCE = 0;
    private final List<Car> winners;

    public Winners(Cars cars) {
        validateWinners(cars);
        winners = cars.getCars().stream()
                .filter(car -> car.getDistance() == getMaxDistance(cars))
                .collect(Collectors.toList());
    }

    public List<String> getWinnersNames() {
        List<String> winnersNames = new ArrayList<>();
        for (Car car : winners) {
            winnersNames.add(car.getName());
        }
        return winnersNames;
    }

    private int getMaxDistance (Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(MIN_DISTANCE);
    }

    private void validateWinners(Cars cars) {
        if(cars.getCars() == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if(!CommonValidator.isPositive(cars.getCars().size()))
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
    }
}
