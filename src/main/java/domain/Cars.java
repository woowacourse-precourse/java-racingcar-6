package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final static String DUP_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    private List<Car> cars = new ArrayList<>();

    public void insertCar(Car car) {
        validateNameDup(car.getName());
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateNameDup(String carName) {
        List<String> carNameList = cars.stream()
                .map(Car::getName)
                .toList();

        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException(DUP_ERROR_MESSAGE);
        }
    }
}
