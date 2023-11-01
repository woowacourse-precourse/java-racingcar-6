package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Cars {
  public List<Entry<String,Integer>> cars;
  //new AbstractMap.SimpleEntry<>("key", 42);
  public Cars() {
    cars = new ArrayList<>();
  }

  public Cars(List<Entry<String,Integer>> cars) {
    this.cars = cars;
  }

  public void addCar(String carName) {
    cars.add(new SimpleEntry<>(carName, GameConstant.STARTPOSITION));
  }

  public List<Entry<String,Integer>> getCars() {
    return cars;
  }

  public void moveCar(Entry<String,Integer> car) {
    car.setValue(car.getValue() + GameConstant.MOVEINTERVAL);
  }
  
}
