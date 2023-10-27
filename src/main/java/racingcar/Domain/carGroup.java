package racingcar.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarGroup {
    private final Map<Integer, Car> car_group;

    private CarGroup(Map<Integer, Car> carGroup) {
        this.car_group = carGroup;
    }

    public static CarGroup of(List<String> carGroup) {
        Map<Integer, Car> car_group = new HashMap<>();
        for (int i = 0; i < carGroup.size(); i++) {
            car_group.put(i+1, Car.of(carGroup.get(i)));
        }

        return new CarGroup(car_group);
    }

    public Integer findSize() {
        return this.car_group.size();
    }

    public Car findCarByOrder(Integer order) {
        return this.car_group.get(order);
    }
}
