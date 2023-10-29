package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public final class CarDtoMapper {
    public static List<Car> mapToCar(CarDto carDto) {
        String carNamesWithCommas = carDto.carNamesWithCommas();
        String[] trimAndSplitCarNames = CarDtoParser.trimAndSplit(carNamesWithCommas);

        List<Car> cars = new ArrayList<>();
        for (String carName : trimAndSplitCarNames) {
            cars.add(Car.createCar(carName, 0));
        }

        return cars;
    }
}
