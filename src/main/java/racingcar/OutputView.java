package racingcar;

import java.util.List;

public class OutputView {

  public void printTrial(List<String> cars, List<Integer> locations) {
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i) + " : " + "-".repeat(locations.get(i)));
    }
    System.out.println();
  }

}
