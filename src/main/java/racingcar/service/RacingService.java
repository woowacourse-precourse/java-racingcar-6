package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RacingService {
    public List<String> stringToList(String str) {
        String[] strArr = str.split(",");
        return new ArrayList<>(Arrays.asList(strArr));
    }

    public int generateRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    public List<Car> generateCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for(String name : names) {
            Car car = new Car(name, 0);
            cars.add(car);
        }
        return cars;
    }
}
