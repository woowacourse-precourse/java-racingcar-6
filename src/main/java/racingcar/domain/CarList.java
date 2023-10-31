package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        carNameList.forEach(carName -> {
            Car car = new Car(carName);
            isNameRange(car);
            isNameDupe(car);
            carList.add(car);
        });
    }
    public List<Car> getCarList() {
        return carList;
    }

    public void isNameRange(Car car) {
        if (car.getName().length() > 5) {
            throw new IllegalArgumentException("5자리 이하만 입력");
        }
    }

    public void isNameDupe(Car car) {
        if (carList.contains(car)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }
    }

    public void printCarList() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

}
