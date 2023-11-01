package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.utils.StringParser;

public final class CarDtoMapper {
    private CarDtoMapper() {
    }

    /**
     * CarDto -> List<Car> 로 변환
     *
     * @param carDto :: CarDto
     * @return List<Car></Car>
     */
    public static List<Car> fromCarDto(CarDto carDto) {
        String carNamesWithCommas = carDto.carNames();
        String[] trimAndSplitCarNames = StringParser.trimAndSplit(carNamesWithCommas);

        List<Car> cars = new ArrayList<>();
        for (String carName : trimAndSplitCarNames) {
            cars.add(Car.createCar(carName, 0));
        }

        return cars;
    }

    /**
     * List<Car> -> CarDto 로 변환
     *
     * @param cars :: List<Car>
     * @return CarDto
     */
    public static CarDto fromListOfCars(List<Car> cars) {
        String collectedCarNames = cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
        return new CarDto(collectedCarNames);
    }
}
