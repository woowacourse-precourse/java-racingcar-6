package racingcar.model;

import racingcar.util.Utils;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        List<String> carNameList = Utils.toList(carNames);
        new CarNameValidator(Utils.toList(carNames));
        carNameList.stream().forEach(name -> cars.add(new Car(name)));
    }

}
