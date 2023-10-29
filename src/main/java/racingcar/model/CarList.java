package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        carNameList.forEach(carName -> {
            Car car = new Car(carName);
            isDuplicate(car);
            carList.add(car);
        });
    }

    private void isDuplicate(Car car) {
        if(carList.contains(car)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.toString());
        }
        return sb.toString();
    }
}
