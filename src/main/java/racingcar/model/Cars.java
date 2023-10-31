package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private List<Car> carList;

  public Cars(List<String> nameList) {
    this.carList = new ArrayList<>();
    for (String name : nameList) {
      carList.add(new Car(name));
    }
  }

  public List<Car> getCarList() {
    return carList;
  }

  public void moveCars() {
    for (Car car : carList) {
      car.setMovement();
    }
  }
}
