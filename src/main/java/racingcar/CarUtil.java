package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarUtil {

    public List<Car> parseCarName(String input) {
        List<Car> cars = new ArrayList<>();

        if (input.contains(",")) {
            for (String car : input.split(",")) {
                cars.add(new Car(car));
            }
        } else {
            cars.add(new Car(input));
        }

        return cars;
    }

}
