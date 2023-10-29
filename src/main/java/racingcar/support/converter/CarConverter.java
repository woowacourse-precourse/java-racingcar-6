package racingcar.support.converter;

import java.util.List;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;

public class CarConverter {

    private CarConverter() {
    }


    public static Car from(CarName carName) {
        return new Car(carName);
    }

    public static List<Car> from(List<CarName> carNames) {
        return carNames.stream()
            .map(CarConverter::from)
            .toList();
    }
}
