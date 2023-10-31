package racingcar.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.race.Car;

public class CarRaceResultsSave {

    private final Car car;

    public CarRaceResultsSave(Car car) {
        this.car = car;
    }

    public void carMovingDistanceCalculation(List<String> carNames, int tryTimes) {

        while (tryTimes > 0) {
            car.racingStarts(carNames);
            carDistanceOutput();
            System.out.println();
            tryTimes--;
        }

    }

    public void carDistanceOutput() {

        for (Entry<String, String> map : getCarMoveCheck().entrySet()) {
            System.out.printf("%s : %s\n", map.getKey(), map.getValue());
        }

    }

    private Map<String, String> getCarMoveCheck() {

        return car.getCarsDistanceData();

    }
}
