package racingcar.model.repository;

import java.util.HashMap;
import racingcar.model.Car;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;

public class InMemoryRepository {

    private static HashMap<CarName, Car> carHashMap = new HashMap<>();
    private static Attempt attempt;

    public void save(CarName carName, Car car) {
        carHashMap.put(carName, car);
    }

    public Car findByCarName(CarName carName) {
        return carHashMap.get(carName);
    }

    public void save(Attempt attempt) {
        this.attempt = attempt;
    }

    public Attempt findAttempt() {
        return this.attempt;
    }
}
