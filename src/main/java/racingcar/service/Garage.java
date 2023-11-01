package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface Garage {

  void save(Car car);
  void updateAll(List<Car> cars);

  List<Car> findAll();
}
