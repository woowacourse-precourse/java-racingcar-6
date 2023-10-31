package racingcar.model;

import racingcar.util.RandomNum;

import java.util.List;
import java.util.Map;

public class RacingCarService {
    Cars cars = new Cars();
    GameCount gameCount = new GameCount();

    public Cars executeResult() {
        Map<String, Integer> carsData = cars.getCarsData();
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            execute(carsData);
        }
        return cars;
    }

    public List<String> setWinner() {
        return cars.getCarsData().entrySet()
                .stream()
                .filter(entry -> entry.getValue() == gameCount.getHighStep())
                .map(Map.Entry::getKey)
                .toList();
    }


    private static void execute(Map<String, Integer> carsData) {
        for (String carName : carsData.keySet()) {
            int getrandomNum = RandomNum.getrandomNum();
            if (getrandomNum >= 4) {
                int moveCnt = carsData.get(carName);
                carsData.replace(carName, ++moveCnt);
            }
        }
    }
}
