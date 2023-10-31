package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.RacingCarValidation;

public class CarList {

    private static List<Car> carList;

    public CarList(String name) {
        List<Car> cars = parsingCarNames(name);
        RacingCarValidation.isNotAvailCarList(cars);
        RacingCarValidation.isNotAvailCarName(cars);
        carList = cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<Car> parsingCarNames(String name) {
        return Arrays.stream(name.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }


    public List<String> getCarNames() {
        return carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
