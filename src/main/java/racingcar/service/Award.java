package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

/*
  최종 우승자 집계
 */
public interface Award {

  List<String> getFinalWinners(List<Car> finalCars);
}
