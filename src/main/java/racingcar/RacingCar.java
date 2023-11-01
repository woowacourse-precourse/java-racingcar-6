package racingcar;

import java.util.List;
import java.util.TreeSet;

public class RacingCar implements Comparable {
  String name;
  int advance;
  static List<RacingCar> carOrder;

  public RacingCar(String name) {
    this.name = name;
    this.advance = 0;
  }

  public void goForward() {
    this.advance++;
  }

  public String showCarsStatus() {
    return "-".repeat(this.advance);
  }

  //		public static 메서드

  @Override
  public int compareTo(Object o) {
    RacingCar competitor = (RacingCar) o;

    if (name.equals(competitor.name)) {
      return 0;
    }

    if (competitor.advance < this.advance) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
