package racingcar.domain.subclass;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MockCars {
    private List<MockCar> cars;

    public MockCars(List<MockCar> cars){
        this.cars = cars;
    }

    public List<String> determineWinner() {
        final MockCar maxPositionCar = findMaxPositioncar();
        return findSamePositionCar(maxPositionCar);
    }

    public List<MockCar> getCars(){
        return Collections.unmodifiableList(cars);
    }

    private MockCar findMaxPositioncar() {
        return cars.stream()
                .max(MockCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findSamePositionCar(MockCar maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(MockCar::getName)
                .collect(Collectors.toList());
    }
}
