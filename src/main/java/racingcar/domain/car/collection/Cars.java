package racingcar.domain.car.collection;

import racingcar.constants.ErrorConsts;
import racingcar.domain.car.Car;
import racingcar.domain.car.dto.CarDto;
import racingcar.domain.car.wrapper.Name;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_DELIMITER = "\n";

    private final List<Car> carList;

    public Cars(final List<Name> carNameList) {
        validate(carNameList);
        this.carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return carList.stream().map(Car::toString).collect(Collectors.joining(CAR_DELIMITER));
    }

    public Names getWinnerNames() {
        final Car winnerCar = getWinnerCar();

        /**
         * Stream API의 성능을 위해 메소드 분리 X
         * Getter를 사용하지 않고 디미터의 법칙을 지키면서 Car -> CarDto -> Names로 가는 방법 고민해보기
         */
        return carList.stream()
                .filter(winnerCar::isSamePosition)
                .map(Car::toCarDto)
                .map(CarDto::name)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Names::new));
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    private void validate(final List<Name> carNameList) {
        validateDuplication(carNameList);
    }

    private void validateDuplication(final List<Name> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorConsts.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private Car getWinnerCar() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorConsts.NO_WINNER_CAR.getMessage()));
    }
}
