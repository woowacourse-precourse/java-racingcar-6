package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<String> determineWinner() {
        final Car maxPositionCar = findMaxPositioncar();
        return findSamePositionCar(maxPositionCar);
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

    private Car findMaxPositioncar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findSamePositionCar(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
