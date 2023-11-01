package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GarageService implements Garage {

  private final List<Car> garage = new ArrayList<>();

  @Override
  public void save(Car car) {
    this.garage.add(car);
  }

  @Override
  public void updateAll(List<Car> cars) {
    this.garage.clear();
    this.garage.addAll(cars);
  }

  @Override
  public List<Car> findAll() {
    return this.garage;
  }
}
