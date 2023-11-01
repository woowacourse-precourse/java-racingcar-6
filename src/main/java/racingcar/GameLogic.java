package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import camp.nextstep.edu.missionutils.Randoms;

public class GameLogic {
  public InputOutput io = new InputOutput();
  public Cars racecars = new Cars();

  public void startGame() {
    setupGame();
    
  }

  public void setupGame() {
    setupCars();
    
  }

  public void setupCars() {
    String[] carNames = io.getCarNames();
    for (String carName : carNames) {
      racecars.addCar(carName);
    }
  }

  public boolean runSuccess() {
    int roll = Randoms.pickNumberInRange(0,9);
    return roll >= 4;
  }

}
