package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarGame {
  private List<Car> cars;
  private Integer attempts;
  public CarGame() {
    cars = new ArrayList<Car>();
    attempts = 0;
  }
}
