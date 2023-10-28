package racingcar.model.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;

public class CarRepository {
    List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void save(String name) {
        cars.add(new Car(name));
    }

    public void carForward() {
        cars.forEach(car -> {
            if (makeRandomNumber() >= 4) {
                car.setForward(car.getForward() + 1);
            }
        });
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
