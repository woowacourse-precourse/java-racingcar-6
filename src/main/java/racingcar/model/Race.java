package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Car> getCars() {
        return cars;
    }
}
