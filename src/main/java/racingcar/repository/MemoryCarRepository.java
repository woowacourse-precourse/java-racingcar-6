package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class MemoryCarRepository implements CarRepository {
    private static List<Car> carList = new ArrayList<>();

    @Override
    public void save(String name) {
        carList.add(new Car(name));
    }

    @Override
    public List<Car> getCarList() {
        return carList;
    }
}
