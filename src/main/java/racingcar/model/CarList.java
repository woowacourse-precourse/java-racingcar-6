package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private void isDuplicate(Car car) {
        if(carList.contains(car)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
