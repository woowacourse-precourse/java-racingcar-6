package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User user = new User();

    public List<Car> createCars(List<String> carNames, Long repeat) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }


}
