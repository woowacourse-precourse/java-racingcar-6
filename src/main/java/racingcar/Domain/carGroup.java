package racingcar.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class carGroup {
    private final Map<Integer, car> car_group;

    private carGroup(Map<Integer, car> carGroup) {
        this.car_group = carGroup;
    }

    public static carGroup of(List<String> carGroup) {
        Map<Integer, car> car_group = new HashMap<>();
        for (int i = 0; i < carGroup.size(); i++) {
            car_group.put(i+1, car.of(carGroup.get(i)));
        }

        return new carGroup(car_group);
    }

    public Integer findSize() {
        return this.car_group.size();
    }

    public car findCarByOrder(Integer order) {
        return this.car_group.get(order);
    }
}
