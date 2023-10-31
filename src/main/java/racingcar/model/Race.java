package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
  private List<Car> cars;

  public Race(List<Car> cars){
    this.cars = cars;
  }

  public int getRandomValue(){
    int randomValue = Randoms.pickNumberInRange(0,9);
    return randomValue;
  }

}
