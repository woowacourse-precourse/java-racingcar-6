package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.NumberGenerator;

public class RaceService {

    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final RecordService recordService = new RecordService();



    public List<String> raceRoundResult(List<Car> cars) {
        List<String> recordResult = new ArrayList<>();
        for (Car car : cars) {
            if (numberGenerator.generate() >= 4)
                car.move();
            recordResult.add(recordService.madeCarResult(car));
        }
        return recordResult;
    }
}
