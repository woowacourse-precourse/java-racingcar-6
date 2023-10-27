package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.constants.ErrorConstants.NOT_CONTAINS_CAR_ERROR_MESSAGE;

public class RaceCars {
    private static final String JOIN_DELIMITER = ", ";
    private static final int START_INDEX = 0;
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size(){
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinningCarNames(){
        final Car maxMovementCountCar = maxCarMovementCount();
        return getSameCarsNames(maxMovementCountCar);
    }

    private String getSameCarsNames(Car maxMovementCountCar) {
        return cars.stream()
                .filter(maxMovementCountCar::findSameCar)
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_DELIMITER));
    }

    private Car maxCarMovementCount(){
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NOT_CONTAINS_CAR_ERROR_MESSAGE));
    }

    public void executeRace(int[] randoms){
        IntStream.range(START_INDEX, randoms.length)
                .forEach(index -> cars.get(index).controlMovement(randoms[index]));
    }

}
