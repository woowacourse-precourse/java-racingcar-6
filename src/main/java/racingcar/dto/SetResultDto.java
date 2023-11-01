package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.Set;
import racingcar.model.Car;

public record SetResultDto(LinkedHashMap<String, Integer> cars) {
    public SetResultDto(Car cars) {
        this(cars.getCars());
    }

    public Set<String> getCarNameSet() {
        return cars.keySet();
    }

    public int getMove(String carName) {
        return cars.get(carName);
    }
}
