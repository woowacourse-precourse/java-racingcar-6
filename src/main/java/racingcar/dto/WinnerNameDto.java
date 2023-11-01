package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record WinnerNameDto(List<String> names) {

    public static WinnerNameDto from(final List<Car> cars) {

        return new WinnerNameDto(cars.stream()
                .map(Car::getNameString)
                .toList());
    }
}
