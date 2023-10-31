package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;
import racingcar.utils.StringUtils;
import racingcar.utils.constant.Constant;
import racingcar.utils.validation.InputValidation;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        List<String> carList = StringUtils.split(carNames);
        InputValidation.validateNameDuplicated(carList);
        this.cars = createCars(carList);

    }

    private List<Car> createCars(List<String> carList) {
        return carList.stream()
            .map(car -> new Car(car))
            .toList();
    }

    public void move() {
        cars.forEach(c -> c.move(RandomUtils.pickRandomNumber()));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
