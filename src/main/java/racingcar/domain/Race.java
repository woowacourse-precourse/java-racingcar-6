package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    static List<Car> carRace = new ArrayList<>();

    static void makeCars(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Car car = new Car(list.get(i));
            carRace.add(car);
        }
    }
}
