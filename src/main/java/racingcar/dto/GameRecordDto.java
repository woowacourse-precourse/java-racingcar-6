package racingcar.dto;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class GameRecordDto {
    private final Map<Integer, List<String>> record;
    private final List<Car> cars;

    public GameRecordDto(Map<Integer, List<String>> record, List<Car> cars) {
        this.record = record;
        this.cars = cars;
    }

    public Map<Integer, List<String>> getRecord() {
        return record;
    }

    public List<Car> getCars() {
        return cars;
    }
}
