package racingcar.model;

import racingcar.constants.Texts;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners;

    public Winners(Cars cars, int maxCount) {
        winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getCount() == maxCount) {
                winners.add(car.getName());
            }
        }
    }
}
