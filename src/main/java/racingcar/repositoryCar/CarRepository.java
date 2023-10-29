package racingcar.repositoryCar;

import racingcar.model.Car;

import java.util.List;

public interface CarRepository {
    public String[] getWinnerName();
    public void save(Car car);
    public void updatePosition();
    public List<Car> getCarList();
}
