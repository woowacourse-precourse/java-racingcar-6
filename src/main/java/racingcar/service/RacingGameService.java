package racingcar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.Logs;
import racingcar.domain.Position;

public class RacingGameService {

    private final int FORWARD = 1;

    public Map<String, String> getUpdatedLogs(Position position, Logs logs) {
        updatePositionAndLogs(position, logs);
        return logs.getLogs();
    }

    private void updatePositionAndLogs(Position carsPosition, Logs logs) {
        Set<String> cars = carsPosition.getPosition().keySet();
        for (String car : cars) {
            carsPosition.update(car, FORWARD);
            int position = carsPosition.getPosition().get(car);
            logs.update(car, position);
        }
    }

    public String checkWinner(Map<String, Integer> position, int count) {
        List<String> winners = new ArrayList<>();
        Set<String> cars = position.keySet();
        int maxPosition = Collections.max(position.values());
        cars.stream().filter(car -> position.get(car) == maxPosition)
                .forEach(car -> winners.add(car));
        return String.join(", ", winners);
    }


    public Cars generateCars(String carsInput) {
        return new Cars(carsInput);
    }

    public Count generateCarsGameCount(String countInput) {
        return new Count(countInput);
    }

    public Position generateCarsPosition(Map<String, Integer> carsMap, int carsGameCount) {
        return new Position(carsMap, carsGameCount);
    }

    public Logs generateCarsGameLogs(Map<String, Integer> carsMap) {
        return new Logs(carsMap);
    }
}
