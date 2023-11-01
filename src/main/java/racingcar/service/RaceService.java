package racingcar.service;

import static racingcar.constant.NumberConstant.MIN_RESTRICT_NUMBER;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.NumberGenerator;

public class RaceService {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final RecordService recordService = new RecordService();

    public List<String> raceRoundResult(List<Car> cars) {
        List<String> recordResult = new ArrayList<>();
        moveProcess(cars, recordResult);
        return recordResult;
    }

    private void moveProcess(List<Car> cars, List<String> recordResult) {
        for (Car car : cars) {
            if (numberGenerator.generate() >= MIN_RESTRICT_NUMBER.getNumber()) {
                car.move();
            }
            recordResult.add(recordService.madeCarResult(car));
        }
    }
}
