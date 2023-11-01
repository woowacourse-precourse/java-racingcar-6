package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class GameLogic {
  public InputOutput io = new InputOutput();

  public boolean runSuccess() {
    int roll = Randoms.pickNumberInRange(0,9);
    return roll >= 4;
  }

  public void logic() {
    io.getCarName();
  }
}
