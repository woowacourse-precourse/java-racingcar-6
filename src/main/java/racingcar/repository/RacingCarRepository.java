package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarRepository {

    private List<Car> store = new ArrayList<>();

    public void save(List<Car> cars) {
        store = cars;
    }
}
