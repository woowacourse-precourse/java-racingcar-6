package racingcar.model;

import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(Cars cars) {
        validateWinners(cars);
        int max = cars.getCars().stream()
                .mapToInt(car -> car.getDistance())
                .boxed()
                .max(Integer::compare)
                .get();
        winners = cars.getCars().stream().filter(car -> car.getDistance() == max).collect(Collectors.toList());
    }

    public List<String> getWinnersNames() {
        List<String> winnersNames = new ArrayList<>();
        for (Car car : winners) {
            winnersNames.add(car.getName());
        }
        return winnersNames;
    }

    private void validateWinners(Cars cars) {
        if(cars.getCars() == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if(cars.getCars().size() < 1)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
    }
}
