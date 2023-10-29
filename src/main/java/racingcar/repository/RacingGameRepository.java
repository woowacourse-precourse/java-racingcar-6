package racingcar.repository;

import java.util.List;

public class RacingGameRepository {
    public List<String> getCar() {
        return Car.getInstance().getCars();
    }

    public void saveCar(List<String> cars) {
        Car.getInstance().setCars(cars);
    }
}
