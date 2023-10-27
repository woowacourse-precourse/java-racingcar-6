package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class FindWin {

    private static int findMaxResult(List<Car> cars) {
        int max = 0;
        for (int i=0; i<cars.size(); i++) {
            max = Math.max(max, cars.get(i).length);
        }
        return max;
    }

    public static List<String> findWinCars(List<Car> cars) {
        List<String> winCars = new ArrayList<>();
        int max = findMaxResult(cars);
        for (Car car : cars) {
            if (car.length == max) {
                winCars.add(car.name);
            }
        }

        return winCars;
    }



}
