package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarController {

    public List<Car> createCars(List<String> names) {
        return names.stream().map(Car::of).collect(Collectors.toList());
    }

    public void race(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum < 4) {
            return;
        }
        car.addDistance();
    }

    public List<String> checkWinner(ArrayList<Car> cars) {
        int max = cars.stream().mapToInt(Car::getDistance).max().getAsInt();
        return cars.stream().filter(car -> car.getDistance() == max).map(Car::getName).toList();
    }
}
