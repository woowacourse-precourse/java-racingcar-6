package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Constant;

public class GameService {
    public GameService() {
    }

    public static GameService getInstance() {
        return GameService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameService INSTANCE = new GameService();
    }

    public List<Car> toCarList(String input) {
        List<Car> cars = new ArrayList<>();

        for (String car : input.split(Constant.SPLIT_UNIT)) {
            cars.add(new Car(car));
        }

        return cars;
    }
}
