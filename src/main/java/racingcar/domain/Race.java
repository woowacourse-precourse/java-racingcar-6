package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public Race(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            boolean shouldMove = Randoms.pickNumberInRange(0, 9) >= 4;
            car.move(shouldMove);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
