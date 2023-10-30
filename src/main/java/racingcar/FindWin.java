package racingcar;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindWin {

    private static int findMaxResult(List<Car> cars) {
        Collections.sort(cars);
        return cars.get(0).length;
    }

    public static List<String> findWinCars(List<Car> cars) {
        List<String> winCars = new ArrayList<>();
        int max = findMaxResult(cars);
        Collections.sort(cars);
        for (Car car : cars) {
            if (car.length == max) {
                winCars.add(car.name);
            } else if(car.length < max) {
                break;
            }
        }

        return winCars;
    }



}
