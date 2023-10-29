package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;

public class CarsDto {

    private final Cars cars;

    private CarsDto(Cars cars) {
        this.cars = cars;
    }

    public static CarsDto createCars(String userInput) {
        List<Car> carList = toCarList(userInput);
        return new CarsDto(Cars.createCars(carList));

    }

    private static List<Car> toCarList(String userInput) {
        String[] splitList = userInput.split(",");
        return Arrays.stream(splitList)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return cars;
    }
}
