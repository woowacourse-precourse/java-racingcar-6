package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cars {
    private final List<car> carList;

    public cars(List<String> carNames) {
        ArrayList<car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new car(carName));
        }
        this.carList = cars;
    }

    public List<car> tryToMove() {
        for (car car : carList) {
            car.triesToMove();
        }
        return getCurrentStatus();
    }

    public List<car> getCurrentStatus() {
        return Collections.unmodifiableList(carList);
    }
}
