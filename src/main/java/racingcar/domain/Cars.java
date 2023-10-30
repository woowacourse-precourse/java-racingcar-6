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
        forceStop(isValidateName());
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

    public boolean isValidateName() {
        return carList.stream()
                .noneMatch(car -> car.getName().length() > 5 || car.getName().isEmpty());
    }

    public void forceStop(boolean isValidateName) {
        if (!isValidateName) {
            throw new IllegalArgumentException("차량 이름이 올바르지 않습니다.");
        }
    }
}
