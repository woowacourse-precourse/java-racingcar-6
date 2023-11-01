package racingcar.Domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarGroup {
    private final Map<Integer, Car> car_group;

    private CarGroup(Map<Integer, Car> carGroup) {
        this.car_group = carGroup;
    }

    public static CarGroup of(List<String> carGroup) {
        Map<Integer, Car> car_group = new LinkedHashMap<>();
        for (int i = 0; i < carGroup.size(); i++) {
            car_group.put(i + 1, Car.of(carGroup.get(i)));
        }

        return new CarGroup(car_group);
    }

    public Integer findSize() {
        return this.car_group.size();
    }

    public Car findCarByOrder(Integer order) {
        return this.car_group.get(order);
    }

    public CarGroup findFinalWinner() {
        Integer maxPosition = 0;
        for (Car car : this.car_group.values()) {
            maxPosition = Math.max(maxPosition, car.findPosition());
        }

        Map<Integer, Car> finalWinners = new LinkedHashMap<>();
        for (Car car : this.car_group.values()) {
            if (car.findPosition().equals(maxPosition)) {
                finalWinners.put(finalWinners.size() + 1, car);
            }
        }

        return new CarGroup(finalWinners);

    }

    public List<String> findCarNames() {
        return this.car_group.values().stream()
                .map(Car::findName)
                .toList();
    }
}
