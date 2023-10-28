package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Commentator {

    public static List<String> getRacingState(Setting setting) {
        List<Car> cars = setting.getCars();
        List<String> states = new ArrayList<>();

        for (Car car : cars) {
            states.add(car.getName() + " : " + car.getForwardState());
        }

        return states;
    }
}
