package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.Set;
import racingcar.model.Car;

public class SetResultDto {
    private final LinkedHashMap<String, Integer> cars;

    public SetResultDto(Car cars) {
        this.cars = cars.getCars();
    }

    public Set<String> getCarNameSet() {
        return cars.keySet();
    }

    public int getMove(String carName) {
        return cars.get(carName);
    }
}
