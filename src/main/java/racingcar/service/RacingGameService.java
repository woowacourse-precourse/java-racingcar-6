package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.Cars;
import racingcar.domain.CarsGameCount;
import racingcar.domain.CarsGameLogs;
import racingcar.domain.CarsPosition;

public class CarsGameService {

    public Map<String,String> getUpdatedLogs(CarsPosition carsPosition, CarsGameLogs carsGameLogs) {
        updatePositionAndLogs(carsPosition, carsGameLogs);
        return carsGameLogs.getLogs();
    }

    private void updatePositionAndLogs(CarsPosition carsPosition, CarsGameLogs carsGameLogs) {
        Set<String> cars = carsPosition.getPosition().keySet();
        for(String car:cars) {
            carsPosition.update(car,1);
            int position = carsPosition.getPosition().get(car);
            carsGameLogs.update(car,position);
        }
    }

    public String checkWinner(Map<String,Integer> position, int count) {
        List<String> winners = new ArrayList<>();
        Set<String> cars = position.keySet();
        cars.stream().filter(car -> position.get(car)  == count)
                .forEach(car -> winners.add(car));
        return String.join(", ", winners);
    }


    public Cars generateCars(String carsInput) {
        return new Cars(carsInput);
    }

    public CarsGameCount generateCarsGameCount(String countInput) {
        return new CarsGameCount(countInput);
    }

    public CarsPosition generateCarsPosition(Map<String, Integer> carsMap, int carsGameCount) {
        return new CarsPosition(carsMap,carsGameCount);
    }

    public CarsGameLogs generateCarsGameLogs(Map<String, Integer> carsMap) {
        return new CarsGameLogs(carsMap);
    }
}
