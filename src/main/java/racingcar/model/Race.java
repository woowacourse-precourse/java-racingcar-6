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
  public void startRace(int moveCount){
    for(int move=0; move<moveCount;move++){
      for(Car car: cars){
        int randomValue = getRandomValue();
        car.move(randomValue);
      }
    }
  }

}
