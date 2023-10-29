package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.exception.CarNamesValidator;
import racingcar.vo.CarName;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<CarName> carNames) {
        CarNamesValidator.validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));

        carList = Collections.unmodifiableList(cars);
    }

    public void move() {
        carList.stream().forEach(car -> car.move());
    }
    
    public List<Car> getCarList() {
        return carList;
    }
}
