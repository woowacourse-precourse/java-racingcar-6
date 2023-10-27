package racingcar.domain.car;

import racingcar.util.Randoms;
import racingcar.view.ExecutionView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.ErrorConstants.NOT_CONTAINS_CAR_ERROR_MESSAGE;

public class RaceCars {
    private static final String JOIN_DELIMITER = ", ";
    //자료 구조
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size(){
        return cars.size();
    }

    //계산 로직
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

    public void executeRace(){
        cars.stream().forEach(car -> car.controlMovement(Randoms.getNumber()));
    }

    //출력 로직
    public void printGameProgressMessages(){
        cars.stream().forEach(ExecutionView::printExecutionMessage);
    }

    public void printWinningCarNames(){
        ExecutionView.printWinningCarNames(getWinningCarNames());
    }

}
