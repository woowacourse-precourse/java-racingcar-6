package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GameUtils {

    public static List<Car> carFactory(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static boolean isForward() {
        int random = pickNumberInRange(0, 9);

        return random >= 4;
    }
}
