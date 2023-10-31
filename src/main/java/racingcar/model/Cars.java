package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.Error.*;

public class Cars {
    private final List<Car> carList;

    public Cars (List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            if (!validateCarNameDuplication(carList, carName))
                carList.add(new Car(carName));
        }
        this.carList = carList;
    }

    private boolean validateCarNameDuplication(List<Car> carList, String carName) {
        if (carList.stream().anyMatch(car -> car.getName().contains(carName)))
            throwError(DUPLICATE_NAME);
        return false;
    }//수정필요

    public List<Car> getCarList() {
        return carList;
    }
}
