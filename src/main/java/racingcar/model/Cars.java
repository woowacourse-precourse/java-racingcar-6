package racingcar.model;

import racingcar.utils.Parser;
import racingcar.utils.validators.CarNamesValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        CarNamesValidator.validateCarsName(carNames);
        this.cars = makeCarList(Parser.parseCarNames(carNames));
    }

    /**
     * 자동차 이름 배열 -> 자동차 객체 배열로 변경
     */
    private List<Car> makeCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
