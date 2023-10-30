package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public List<Car> createCarList(String inputNames) {
        String[] nameArr = inputNames.split(",");
        carList = Arrays.stream(nameArr)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
        forceStop(isValidate());
        return carList;
    }

    public Car findMaxDistanceCar() {
        return carList.stream()
                .max(Car::compareTo).orElseThrow(() -> new IllegalArgumentException("차량이 존재하지 않습니다."));
    }

    public List<String> findWinner() {
        return carList.stream()
                .filter(car -> car.equals(findMaxDistanceCar()))
                .map(Car::getName)
                .toList();
    }

    public boolean isValidate() {
        return carList.stream()
                .noneMatch(car -> car.getName().length() > 5);
    }

    public void forceStop(boolean isValidate) {
        if (!isValidate) {
            throw new IllegalArgumentException();
        }
    }
}
