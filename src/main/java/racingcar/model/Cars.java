package racingcar.model;

import racingcar.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = carNames.split(Constants.SEPARATOR.getStringValue());
        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
