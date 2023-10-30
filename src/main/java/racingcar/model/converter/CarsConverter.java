package racingcar.model.converter;

import racingcar.model.Cars;
import racingcar.model.dto.CarResponse;
import java.util.List;

public class CarsConverter {

    private CarsConverter() {
    }

    public static List<CarResponse> fromEntity(final Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> CarResponse.of(car.getName(), car.getPosition()))
                .toList();
    }
}
