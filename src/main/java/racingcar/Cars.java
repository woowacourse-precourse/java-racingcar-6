package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

public class Cars {
  private ArrayList<SimpleEntry<String,Integer>> cars;
  //new AbstractMap.SimpleEntry<>("key", 42);
  public Cars() {
    cars = new ArrayList<>();
  }

  public Cars(ArrayList<SimpleEntry<String,Integer>> cars) {
    this.cars = cars;
  }

  
}
