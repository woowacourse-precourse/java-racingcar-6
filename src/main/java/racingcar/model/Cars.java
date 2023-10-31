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

  public List<String> getWinnerList() {
    List<String> winnerList = calculateWinner();
    return winnerList;
  }

  private List<String> calculateWinner() {
    List<String> winnerList = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (Car car : carList) {
      if (car.getMovement() > max) {
        max = car.getMovement();
        winnerList.clear();
        winnerList.add(car.getName());
      } else if (car.getMovement() == max) {
        winnerList.add(car.getName());
      }
    }
    return winnerList;
  }
}
