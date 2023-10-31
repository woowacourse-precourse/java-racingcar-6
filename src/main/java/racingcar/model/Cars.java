package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GenerateCar {
  private List<Car> carList = new ArrayList<>();
  public GenerateCar(List<String> nameList) {
    for (String name : nameList) {
      carList.add(new Car(name));
    }
  }
  public List<Car> getCarList() {
    return carList;
  }
}
