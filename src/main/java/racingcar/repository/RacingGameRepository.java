package racingcar.repository;

import java.util.List;

public class RacingGameRepository {
    public List<CarInfo> getCar() {
        return Car.getInstance().getCars();
    }

    public void saveCar(List<CarInfo> cars) {
        Car.getInstance().setCars(cars);
    }
}
