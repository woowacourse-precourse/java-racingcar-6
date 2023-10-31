package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Error;
import racingcar.util.Utils;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        validateCars(carNames);
        carList = generateCarList(carNames);
    }

    public Car getCar(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }

    private List<Car> generateCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String car : carNames) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private void validateCars(String[] carNames) {
        if (Utils.hasDuplicateMember(carNames)) {
            throw new IllegalArgumentException(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }
}
