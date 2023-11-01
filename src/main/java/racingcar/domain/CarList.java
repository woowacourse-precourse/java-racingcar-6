package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList;

    public CarList(CarNameList carNameList) {
        carList = new ArrayList<>();
        for (String carName : carNameList.getCarNameList()) {
            carList.add(new Car(carName));
        }
    }

    private CarList(List<Car> compCarList) {
        carList = List.copyOf(compCarList);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public CarList getMostDistanceCarList() {
        long maxDistanceValueInCarList = findMaxDistanceValueInCarList();
        List<Car> maxDistanceCars = carList.stream()
                .filter(car -> car.getDistance() == maxDistanceValueInCarList)
                .collect(Collectors.toList());
        return new CarList(maxDistanceCars);
    }

    private long findMaxDistanceValueInCarList() {
        return carList.stream()
                .sorted(Comparator.comparingLong(Car::getDistance).reversed())
                .toList().get(0).getDistance();
    }
}