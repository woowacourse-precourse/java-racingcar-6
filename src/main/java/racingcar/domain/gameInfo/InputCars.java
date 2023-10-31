package racingcar.domain.gameInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.validation.CarInputValidate;

public class InputCars {
    private final List<Car> parsedCarList;

    public InputCars(String p) {
        this.parsedCarList = parseCarList(p);
    }

    public List<Car> getParsedCarList() {
        return parsedCarList;
    }

    private List<Car> parseCarList(String carList) {
        String[] carNames = carList.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .peek(CarInputValidate::carNameLengthValidate)
                .map(Car::new)
                .collect(Collectors.toList());

        CarInputValidate.carDuplicateCheck(carNames);
        return cars;
    }
}
