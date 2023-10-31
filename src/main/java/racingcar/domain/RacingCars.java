package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.common.consts.SystemConst;

public class RacingCars {
    private List<Car> racingCars = new ArrayList<>();

    public RacingCarsResult getRacingCarsResult() {
        sort();
        return findWinners();
    }

    private RacingCarsResult findWinners() {
        RacingCarsResult result = new RacingCarsResult();
        Car highestCar = racingCars.get(0);
        result.add(highestCar);
        int index = 1;
        while (index < racingCars.size() && highestCar.compareTo(racingCars.get(index)) == 0) {
            result.add(racingCars.get(index));
            index++;
        }
        return result;
    }

    public int size() {
        return racingCars.size();
    }

    public void add(Car car) {
        racingCars.add(car);
    }

    public void moveCar() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public void sort() {
        Collections.sort(racingCars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : this.racingCars) {
            sb.append(car.toString());
            sb.append(SystemConst.LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
