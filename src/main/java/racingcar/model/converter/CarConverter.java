package racingcar.model.converter;

import racingcar.model.Car;
import racingcar.model.dto.CarResponse;

public class CarConverter {

    private CarConverter() {
    }

    public static CarResponse fromEntity(final Car car) {
        return CarResponse.of(car.getName(), car.getPosition());
    }
}
